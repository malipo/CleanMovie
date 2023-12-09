package com.mp.cleanmovie.app.navigation

class AppNavigation {
    enum class Screen {
        MOVIE_LIST,
        MOVIE_DETAIL,
    }
    sealed class NavigationItem(val route: String) {
        object MovieList : NavigationItem(Screen.MOVIE_LIST.name)
        object MovieDetail : NavigationItem(Screen.MOVIE_DETAIL.name)
    }
}