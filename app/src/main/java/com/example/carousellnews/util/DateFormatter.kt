package com.example.carousellnews.util

import android.content.Context
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

fun Long.toRelativeTime(context: Context): String {
    // tried using this library but it didn't work for multiple years ago, so i resorted to making it manually
    //val date = DateUtils.getRelativeDateTimeString(context, this*1000, MINUTE_IN_MILLIS, TEN_YEARS_IN_MILLI, 0)
    val now = LocalDateTime.now()
    val timeInstant = Instant.ofEpochMilli(this*1000)
    val expectedTime = timeInstant.atZone(ZoneId.systemDefault()).toLocalDateTime()
    val duration = Duration.between(expectedTime, now).toSeconds()
    val dateFormat = when {
        (duration < 60) -> "$duration Seconds Ago"
        (duration < 3600) -> "${duration / 60} Minutes Ago"
        (duration < 86400) -> "${duration / 3600} Hours Ago"
        (duration < 604800) -> "${duration / 86400} Days Ago"
        (duration < 2628000) -> "${duration / 604800} Weeks Ago"
        (duration < 31536000) -> "${duration / 2628000} Months Ago"
        else -> "${duration / 31536000} Years Ago"

    }
    return dateFormat
}