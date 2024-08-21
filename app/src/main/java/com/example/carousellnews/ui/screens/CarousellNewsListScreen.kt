package com.example.carousellnews.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carousellnews.ui.screens.widget.CarousellNewsItem

@Composable
fun CarousellNewsListScreen(
    modifier: Modifier = Modifier,
    viewModel: CarousellNewsListViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    LaunchedEffect(key1 = true) {
        viewModel.getNews()
    }
    LazyColumn(
        modifier = modifier.padding(bottom = 16.dp)
    ) {
        items(state.value.newsList.size) { index ->
            CarousellNewsItem(
                item = state.value.newsList[index]
            )
        }
    }
}