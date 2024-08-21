package com.example.carousellnews.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carousellnews.ui.screens.widget.CarousellNewsItem
import com.example.carousellnews.ui.theme.Typography
import com.example.carousellnews.ui.theme.carousellRed

@Composable
fun CarousellNewsListScreen(
    modifier: Modifier = Modifier,
    viewModel: CarousellNewsListViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    var menuExpanded by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true) {
        viewModel.getNews()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Carousell News",
                        style = Typography.subtitle1.copy(color = Color.White),
                        maxLines = 2,
                    )
                },
                backgroundColor = carousellRed,
                actions = {
                    IconButton(onClick = { menuExpanded = !menuExpanded }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "More",
                            tint = Color.White,
                        )
                    }
                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false },
                    ) {
                        // 6
                        DropdownMenuItem(
                            onClick = { viewModel.sortByDate() },
                        ) {
                            Text("Recent")
                        }
                        DropdownMenuItem(
                            onClick = { viewModel.sortByRanking() },
                        ) {
                            Text("Popular")
                        }
                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            items(state.value.newsList.size) { index ->
                CarousellNewsItem(
                    item = state.value.newsList[index]
                )
            }
        }
    }
}