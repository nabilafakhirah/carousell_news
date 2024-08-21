package com.example.carousellnews.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carousellnews.data.model.CarousellNewsResponse
import com.example.carousellnews.data.repository.NewsRepository
import com.example.data.util.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CarousellNewsListViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {
    private val _state = mutableStateOf(CarousellNewsListState())
    val state: State<CarousellNewsListState> = _state
    private var newsList = emptyList<CarousellNewsResponse>()

    fun getNews() {
        val newsListResponse = newsRepository.getNews()
        newsListResponse.onEach { result ->
            when (result) {
                is DataResult.Success -> {
                    newsList = result.data.orEmpty().sortedBy { it.time_created }

                    _state.value = CarousellNewsListState(
                        newsList = newsList,
                        isLoading = false,
                        isError = false,
                    )
                }

                is DataResult.Loading -> {
                    _state.value = CarousellNewsListState(
                        isLoading = true,
                        isError = false,
                    )
                }

                is DataResult.Error -> {
                    _state.value = CarousellNewsListState(
                        isLoading = false,
                        isError = true,
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}