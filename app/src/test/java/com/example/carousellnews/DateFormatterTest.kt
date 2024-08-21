package com.example.carousellnews

import com.example.carousellnews.data.api.NewsApi
import com.example.carousellnews.data.model.CarousellNewsResponse
import com.example.carousellnews.data.repository.NewsRepository
import com.example.carousellnews.util.toRelativeTime
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DateFormatterTest {


    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `date formatter functions correctly` () {
        val dateEpoch = 1527672941L
        val relativeDate = dateEpoch.toRelativeTime()

        assertEquals("6 Years Ago", relativeDate)
    }
}