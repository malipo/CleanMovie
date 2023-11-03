package com.mp.cleanmovie.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mp.cleanmovie.presentation.dashboard.BottomBarScreen
import com.mp.cleanmovie.presentation.home.HomeNavigate
import com.mp.cleanmovie.presentation.search.SearchNavigate

const val ROOT = "root_graph"

@Composable
fun DashboardGraph(navController: NavHostController) {
  NavHost(
      navController = navController,
      route = DashboardRoute.Root.route,
      startDestination = BottomBarScreen.Home.route,
  ) {
    composable(route = DashboardRoute.Home.route) { HomeNavigate(navController = navController) }

    composable(route = DashboardRoute.Search.route) { SearchNavigate(navController = navController) }

  }
}


sealed class DashboardRoute {
  object Root : Screen(route = "root_dashboard")
  object Home : Screen(route = "home")
  object Search : Screen(route = "search")
}
