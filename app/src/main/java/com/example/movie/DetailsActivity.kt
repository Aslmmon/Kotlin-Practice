package com.example.movie

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = getIntent()

        val athlete :Athlete =intent.getSerializableExtra("athlete") as Athlete

        detailsAthletename?.text= athlete.name
        detailsAthletebrief?.text=athlete.brief
        if (athlete.image != "") {
            Glide.with(this).load(athlete.image).into(detailsimageView)
        }
        else {
            detailsimageView.visibility= View.GONE
            val params1 = detailsAthletename.getLayoutParams() as RelativeLayout.LayoutParams

            params1.topMargin =100
            detailsAthletename.setLayoutParams(params1)


            val params = detailsAthletebrief.getLayoutParams() as RelativeLayout.LayoutParams
            params.topMargin =500
            detailsAthletebrief.setLayoutParams(params)
        }
    }
}
