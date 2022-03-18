package com.flexcode.mpesauiclone

sealed class Screen(val route: String) {

    object Home: Screen(route = "home_screen")
    object Discover: Screen(route = "discover_screen")
    object Transaction: Screen(route = "transaction_screen")
    object Grow: Screen(route = "grow_screen")
    object Splash: Screen(route = "splash_screen")
}