package com.example.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY
//https://newsapi.org/v2/everything?domains=wsj.com&apiKey=API_KEY

const val Base_url = "https://newsapi.org/"
const val API_key = "5940df3e6ed34065b55185587bacbfbd"

interface NewsInterface {
    @GET("/v2/top-headlines?apiKey=$API_key")
  fun getHeadline(@Query("country")country: String,@Query("page")page: Int):Call<News>
}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(Base_url).addConverterFactory(GsonConverterFactory.create()).build()
        newsInstance=retrofit.create(NewsInterface::class.java)
    }
}