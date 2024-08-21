package com.example.carousellnews.util

import android.content.Context
import android.text.format.DateUtils
import android.text.format.DateUtils.MINUTE_IN_MILLIS

fun Long.toRelativeTime(context: Context): String {
    val date = DateUtils.getRelativeDateTimeString(context, this*1000, MINUTE_IN_MILLIS, TEN_YEARS_IN_MILLI, 0)
    return date.toString()
}