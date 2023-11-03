package com.mp.cleanmovie.presentation.dashboard


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.mp.cleanmovie.presentation.navigation.DashboardRoute

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = DashboardRoute.Home.route,
        title = "Home",
        icon = Icons.Filled.Home
    )

    object Search : BottomBarScreen(
        route = DashboardRoute.Search.route,
        title = "Search",
        icon = Icons.Filled.Search
    )


}