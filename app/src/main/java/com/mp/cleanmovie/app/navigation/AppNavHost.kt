package com.mp.cleanmovie.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mp.cleanmovie.movieList.presentation.screen.MovieDetailScreen
import com.mp.cleanmovie.movieList.presentation.screen.MovieListScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = AppNavigation.NavigationItem.MovieList.route,

    ) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppNavigation.NavigationItem.MovieList.route) {
            MovieListScreen(navController)
        }
//        composable(AppNavigation.NavigationItem.MovieDetail.route) {
//            MovieDetailScreen(navController)
//        }

        composable(
            route = AppNavigation.NavigationItem.MovieDetail.route,
            arguments = listOf(
                navArgument("movieId") {}
            )
        ) { navBackStackEntry ->

            val movieId = navBackStackEntry.arguments?.getString("movieId")

            MovieDetailScreen(movieId!!, navController)
        }

    }
}

fun NavController.navigateToDetail(movieId: String) {
    this.navigate("movie_detail/$movieId")
}