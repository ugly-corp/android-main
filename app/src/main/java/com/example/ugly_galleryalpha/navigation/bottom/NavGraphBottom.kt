package com.example.ugly_galleryalpha.navigation.bottom

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.screens.FavoritePostScreen
import com.example.ugly_galleryalpha.screens.HomeScreen
import com.example.ugly_galleryalpha.screens.MyName
import com.example.ugly_galleryalpha.screens.MyProfileScreen
import com.example.ugly_galleryalpha.screens.SearchCotegoryScreen

@Composable
fun NavGraphBottom(
    navHostController: NavHostController
){
    NavHost(navController = navHostController, startDestination = "screen_home_1"){
        composable("screen_home_1"){
            HomeScreen(rememberNavController()) //Если что изменить на ремембер
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