package com.rushar.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.rushar.newsapp.presentation.navgraph.NavGraph
import com.rushar.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition.value
            }
        }

        setContent {
            NewsAppTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
                    val startDestination = viewModel.startDestination.value
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}
