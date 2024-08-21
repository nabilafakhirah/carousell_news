package com.example.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class CarousellNewsResponse(
    @Json(name="id")
    val id: String,
    @Json(name="title")
    val title: String,
    @Json(name="description")
    val description: String,
    @Json(name="banner_url")
    val bannerUrl: String,
    @Json(name="time_created")
    val timeCreated: Long,
    @Json(name="rank")
    val rank: Int,
) : Parcelable
