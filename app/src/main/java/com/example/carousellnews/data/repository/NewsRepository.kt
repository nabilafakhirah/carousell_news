package com.example.carousellnews.data.repository

import com.example.carousellnews.data.model.CarousellNewsResponse
import com.example.data.util.DataResult
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(): Flow<DataResult<List<CarousellNewsResponse>>>
}