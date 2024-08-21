package com.example.carousellnews.ui.screens.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.carousellnews.R
import com.example.carousellnews.ui.theme.Typography
import com.example.carousellnews.data.model.CarousellNewsResponse
import com.example.carousellnews.util.toRelativeTime

@Composable
fun CarousellNewsItem(
    item: CarousellNewsResponse,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp,
            ),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp)),
                model = item.banner_url,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.img_load_failed),
                error = painterResource(id = R.drawable.img_load_failed),
                contentDescription = "",
            )
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = item.title,
                    style = Typography.h5
                )
                Text(
                    text = item.description,
                    style = Typography.body1,
                    maxLines = 2,
                )
                Text(
                    text = item.time_created.toRelativeTime(),
                    style = Typography.body2,
                )
            }
        }
    }
}
