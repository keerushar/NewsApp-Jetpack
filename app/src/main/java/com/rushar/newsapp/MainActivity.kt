package com.rushar.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.SideEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
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

            val isSystemInDarkMode = isSystemInDarkTheme()
            val systemUiColor = rememberSystemUiController()
            SideEffect {
                systemUiColor.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = !isSystemInDarkMode
                )
            }
            NewsAppTheme {
                Box(modifier = Modifier.background(MaterialTheme.colors.background).fillMaxSize()) {
                    NavGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}
