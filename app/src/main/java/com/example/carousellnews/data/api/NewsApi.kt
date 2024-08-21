package com.example.carousellnews.data.api

import com.example.carousellnews.data.model.CarousellNewsResponse
import retrofit2.http.GET

interface NewsApi {
    @GET("carousell_news.json")
    suspend fun getNews(): List<CarousellNewsResponse>
}