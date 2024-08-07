package com.example.ugly_galleryalpha.Presentation.navigation.bottom

import com.example.ugly_galleryalpha.R

sealed class BottomItem (
    val title: String,
    val iconId: Int,
    val route: String
){
    object ScreenHome: BottomItem("Home", R.drawable.home1, "screen_home_1")
    object ScreenSearch: BottomItem("Search", R.drawable.menu1, "screen_search_2")
    object ScreenFavorite: BottomItem("Favorite", R.drawable.heart1, "screen_favorite_3")
    object ScreenProfile: BottomItem("Profile", R.drawable.user1, "screen_profile_4")
}