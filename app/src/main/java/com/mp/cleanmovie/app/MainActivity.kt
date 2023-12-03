package com.mp.cleanmovie.app

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mp.cleanmovie.core.presentation.dashboard.DashboardScreen
import com.mp.cleanmovie.movieList.presentation.screen.MovieScreen

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // it marks a class as a target for Hilt's dependency injection
// it is used to annotate Android components like Activity, Fragment, Service, BroadcastReceiver, etc., to enable dependency injection in these components.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieScreen()
        }
    }
}
