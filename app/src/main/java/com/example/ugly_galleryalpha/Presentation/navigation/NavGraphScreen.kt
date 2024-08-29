package com.example.ugly_galleryalpha.Presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ugly_galleryalpha.Presentation.navigation.bottom.BottomItem
import com.example.ugly_galleryalpha.Presentation.screens.Auth.AuthScreen
import com.example.ugly_galleryalpha.Presentation.screens.Detail.DetailPostScreen
import com.example.ugly_galleryalpha.Presentation.screens.Favorite.FavoritePostScreen
import com.example.ugly_galleryalpha.Presentation.screens.Home.HomeScreen
import com.example.ugly_galleryalpha.Presentation.screens.MyProfile.MyProfileScreen
import com.example.ugly_galleryalpha.Presentation.screens.Register.RegisterScreen
import com.example.ugly_galleryalpha.Presentation.screens.Search.SearchCategoryScreen
import com.example.ugly_galleryalpha.Presentation.screens.Setting.SettingUserScreen
import com.example.ugly_galleryalpha.Presentation.screens.Start.StartScreen


@Composable
fun NavGraphScreen(
    navHostController: NavController
){
    NavHost(
        navController = navHostController as NavHostController,
        startDestination = ScreenSealed.Start.route
         ){
            composable(
                route = ScreenSealed.Start.route,


            ){
                StartScreen(navController = navHostController)
            }

            composable(
                route = ScreenSealed.Auth.route,
                enterTransition = { fadeIn(animationSpec = tween(700))},
                exitTransition =  { fadeOut(animationSpec = tween(700))}
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
                SearchCategoryScreen()
            }

            composable(
                BottomItem.ScreenFavorite.route
            ){
                FavoritePostScreen()
            }

            composable(
                BottomItem.ScreenProfile.route
            ){
                MyProfileScreen(navController = navHostController, username = "User")
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