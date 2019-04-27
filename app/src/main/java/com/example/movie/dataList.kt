package com.example.movie


import com.google.gson.annotations.SerializedName

data class dataList(@SerializedName("athletes") var athletes: List<Athlete>) {
}