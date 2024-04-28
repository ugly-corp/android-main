package com.example.ugly_galleryalpha.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ugly_galleryalpha.navigation.bottom.BottomItem
import com.example.ugly_galleryalpha.screens.AuthScreen
import com.example.ugly_galleryalpha.screens.DetailPostScreen
import com.example.ugly_galleryalpha.screens.FavoritePostScreen
import com.example.ugly_galleryalpha.screens.HomeScreen
import com.example.ugly_galleryalpha.screens.MyProfileScreen
import com.example.ugly_galleryalpha.screens.RegisterScreen
import com.example.ugly_galleryalpha.screens.SearchCotegoryScreen
import com.example.ugly_galleryalpha.screens.SettingUserScreen
import com.example.ugly_galleryalpha.screens.StartScreen


@Composable
fun NavGraphScreen(
    navHostController: NavController
){
    NavHost(
        navController = navHostController as NavHostController,
        startDestination = ScreenSealed.Start.route
         ){
            composable(
                route = ScreenSealed.Start.route
            ){
                StartScreen(navController = navHostController)
            }

            composable(
                route = ScreenSealed.Auth.route
            ){
                RegisterScreen(navController = navHostController)
            }

            composable(
                route = ScreenSealed.Register.route
            ){
                AuthScreen(navController = navHostController)
            }

            composable(
                route = ScreenSealed.Home.route
            ){
                HomeScreen(navController = navHostController)
            }

            // Navigation bar
            composable(
                route = BottomItem.ScreenHome.route
            ){
                HomeScreen(navController = navHostController)
            }

            composable(
                BottomItem.ScreenSearch.route
            ){
                SearchCotegoryScreen()
            }

            composable(
                BottomItem.ScreenFavorite.route
            ){
                FavoritePostScreen()
            }

            composable(
                BottomItem.ScreenProfile.route
            ){
                MyProfileScreen(navController = navHostController)
            }

        // код с открытием внизу

            //открытия поста (пока не придумал как именно) ->
        composable(ScreenSealed.DetailPost.route) {
            DetailPostScreen(navController = navHostController)
        }

            composable(
                route = ScreenSealed.UserSettings.route
            ){
                SettingUserScreen(navController = navHostController)
            }
    }
}