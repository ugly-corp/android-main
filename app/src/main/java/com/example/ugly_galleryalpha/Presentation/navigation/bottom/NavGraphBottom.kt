package com.example.ugly_galleryalpha.Presentation.navigation.bottom

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.Presentation.screens.Favorite.FavoritePostScreen
import com.example.ugly_galleryalpha.Presentation.screens.Home.HomeScreen
import com.example.ugly_galleryalpha.Presentation.screens.MyProfile.MyProfileScreen
import com.example.ugly_galleryalpha.Presentation.screens.Search.SearchCotegoryScreen

@Composable
fun NavGraphBottom(
    navHostController: NavHostController
){
    NavHost(navController = navHostController, startDestination = "screen_home_1"){
        composable("screen_home_1"){
            navHostController.popBackStack()
            HomeScreen(rememberNavController())
        }
        composable("screen_search_2"){
            SearchCotegoryScreen()
        }
        composable("screen_favorite_3"){
            FavoritePostScreen()
        }
        composable("screen_profile_4"){
            MyProfileScreen(rememberNavController(), username = "User")
        }
    }
}