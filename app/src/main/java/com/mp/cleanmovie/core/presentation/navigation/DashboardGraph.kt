package com.mp.cleanmovie.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mp.cleanmovie.movieList.presentation.screen.MovieScreen
import com.mp.cleanmovie.core.presentation.dashboard.BottomBarScreen
import com.mp.cleanmovie.core.presentation.home.HomeNavigate
import com.mp.cleanmovie.core.presentation.search.SearchNavigate

const val ROOT = "root_graph"

@Composable
fun DashboardGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = DashboardRoute.Root.route,
        startDestination = BottomBarScreen.MovieList.route,
    ) {
        composable(route = DashboardRoute.MovieList.route) { MovieScreen() }

        composable(route = DashboardRoute.Home.route) { HomeNavigate(navController = navController) }

        composable(route = DashboardRoute.Search.route) { SearchNavigate(navController = navController) }
    }
}

sealed class DashboardRoute {
    object Root : Screen(route = "root_dashboard")
    object Home : Screen(route = "home")
    object Search : Screen(route = "search")
    object MovieList : Screen(route = "movieList")
}
