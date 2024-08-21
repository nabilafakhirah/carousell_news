package com.example.data.repository

import com.example.data.model.CarousellNewsResponse
import com.example.data.util.DataResult
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(): Flow<DataResult<List<CarousellNewsResponse>>>
}