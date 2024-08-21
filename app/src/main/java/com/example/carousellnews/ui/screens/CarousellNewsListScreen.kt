package com.example.carousellnews.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carousellnews.ui.screens.widget.CarousellNewsItem

@Composable
fun CarousellNewsListScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(bottom = 16.dp)
    ) {
        items(5) { index ->
            CarousellNewsItem()
        }
    }
}