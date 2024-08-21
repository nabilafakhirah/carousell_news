package com.example.carousellnews.ui.screens

import com.example.carousellnews.data.model.CarousellNewsResponse

data class CarousellNewsListState(
    val newsList: List<CarousellNewsResponse> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)