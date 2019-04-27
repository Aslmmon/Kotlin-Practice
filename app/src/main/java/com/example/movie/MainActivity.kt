package com.example.movie

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.movie.Retrofit.ApiService
import com.example.movie.Retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitClient.retrofitInstance?.create(ApiService::class.java)
        val call = service?.getAllMovies()

        recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)
        call?.enqueue(object : Callback<dataList> {
            override fun onResponse(call: Call<dataList>?, response: Response<dataList>?) {
                val body = response?.body()
                val athlete = body?.athletes!!
                val adapter = MyAdapter(this@MainActivity, athlete , { movie : Athlete -> movieItemClicked(movie) })
                recyclerView.adapter = adapter
            }
            override fun onFailure(call: Call<dataList>?, t: Throwable?) {
                // error handel it TODO
            }
        })
    }
    private fun movieItemClicked(athlete: Athlete) {

        val intent = Intent(this@MainActivity, DetailsActivity::class.java)


        intent.putExtra("athlete", athlete)
        startActivity(intent)

    }
}
