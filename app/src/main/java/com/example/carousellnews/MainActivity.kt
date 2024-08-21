package com.example.carousellnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.carousellnews.ui.screens.CarousellNewsListScreen
import com.example.carousellnews.ui.theme.CarousellNewsTheme
import com.example.carousellnews.ui.theme.carousellBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarousellNewsTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = carousellBackground
                ) {
                    Scaffold {
                        CarousellNewsListScreen()
                    }
                }
            }
        }
    }
}