package com.example.ugly_galleryalpha.navigation

sealed class ScreenSealed(
    val route: String
){
    object Start: ScreenSealed(route = "start_screen")
    object Auth: ScreenSealed(route = "auth_screen")
    object Register: ScreenSealed(route = "register_screen")
    object Home: ScreenSealed(route = "home_screen")

    object DetailPost: ScreenSealed(route = "detail_post")
}