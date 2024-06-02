package com.example.ugly_galleryalpha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.navigation.NavGraphScreen
import com.example.ugly_galleryalpha.screens.HomeScreen
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ugly_galleryALPHATheme {
                //navController = rememberNavController()
                //NavGraphScreen(navHostController = navController)
                MainScreen()

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ugly_galleryALPHATheme {

    }
}