package com.mp.cleanmovie.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.mp.cleanmovie.app.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // it marks a class as a target for Hilt's dependency injection
// it is used to annotate Android components like Activity, Fragment, Service, BroadcastReceiver, etc., to enable dependency injection in these components.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavHost(navController = rememberNavController())
//            MovieListScreen()
        }
    }
}
