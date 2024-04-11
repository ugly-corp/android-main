package com.example.ugly_galleryalpha

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.navigation.NavGraphScreen
import com.example.ugly_galleryalpha.navigation.ScreenSealed
import com.example.ugly_galleryalpha.navigation.bottom.BottomItem
import com.example.ugly_galleryalpha.navigation.bottom.BottomNavigation
import com.example.ugly_galleryalpha.screens.StartScreen


@Composable
fun shouldShowBottomBar(route: String): Boolean {
    return route in listOf(
        ScreenSealed.Home.route,
        BottomItem.ScreenHome.route,
        BottomItem.ScreenSearch.route,
        BottomItem.ScreenFavorite.route,
        BottomItem.ScreenProfile.route
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val currentRoute = currentRoute(navController)

    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar(currentRoute)) {
                BottomNavigation(navController = navController)
            }
        }
    ){
        NavGraphScreen(navHostController = navController)
    }
}

@Composable
fun currentRoute(navController: NavController): String {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route ?: ""
}