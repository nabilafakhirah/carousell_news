package com.example.data.repository

import com.example.data.api.NewsApi
import com.example.data.model.CarousellNewsResponse
import com.example.data.util.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(): Flow<DataResult<List<CarousellNewsResponse>>> = flow {
        try {
            emit(DataResult.Loading())
            val result = newsApi.getNews()
            emit(DataResult.Success(result))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(DataResult.Error(
                message = "Failed to retrieve news list"
            ))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                DataResult.Error(
                    message = "Failed to retrieve news list"
                ))
        }
    }
}