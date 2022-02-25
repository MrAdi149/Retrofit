package com.example.retrofit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news: Call<News> = NewsService.newsInstance.getHeadline("in", 1)
        news.enqueue(object : retrofit2.Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news: News? =response.body()
                if (news != null) {
                    Log.d("Retrofit", news.toString())
                }
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Retrofit","Error in fetching news",t)
            }
        })
    }
}