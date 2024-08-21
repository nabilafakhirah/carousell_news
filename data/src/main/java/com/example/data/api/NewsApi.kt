package com.example.data.api

import com.example.data.model.CarousellNewsResponse
import retrofit2.http.GET

interface NewsApi {
    @GET("carousell_news.json")
    suspend fun getNews(): List<CarousellNewsResponse>
}