package com.example.carousellnews.ui.screens.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.carousellnews.R
import com.example.carousellnews.ui.theme.Typography

@Composable
fun CarousellNewsItem(
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp)),
                model = "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-hero-image_10june.png",
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
                    text = "Southeast Asia-based mobile listings startup Carousell raises \$85M",
                    style = Typography.h5
                )
                Text(
                    text = "Carousell, the Singapore-based mobile listing service that operates across Southeast Asia, has pulled in an \$85 million Series C fund as it seeks to strengthen its business among the region's competitive e-commerce landscape before expanding globally.",
                    style = Typography.body1,
                    maxLines = 2,
                )
                Text(
                    text = "5 Hours Ago.",
                    style = Typography.body2,
                )
            }
        }
    }
}

@Preview
@Composable
private fun CarousellNewsItemPreview() {
    CarousellNewsItem()
}
