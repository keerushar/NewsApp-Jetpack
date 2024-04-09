package com.rushar.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rushar.newsapp.presentation.onboarding.OnBoardingScreen
import com.rushar.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            NewsAppTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
                    OnBoardingScreen()
                }
            }
        }
    }
}
