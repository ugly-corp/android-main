package com.example.ugly_galleryalpha.Presentation.navigation.bottom

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.Presentation.navigation.ScreenSealed
import com.example.ugly_galleryalpha.ui.theme.UGreen

@Composable
fun BottomNavigation(
    navController: NavController
){
    val listItems = listOf(
        BottomItem.ScreenHome,
        BottomItem.ScreenSearch,
        BottomItem.ScreenFavorite,
        BottomItem.ScreenProfile
    )

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRounte = backStackEntry?.destination?.route

    val shouldShowBottomBar = currentRounte != ScreenSealed.Start.route

    if (shouldShowBottomBar) {
        androidx.compose.material.BottomNavigation(
            backgroundColor = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(25.dp))
        ) {
            listItems.forEach { item ->
                BottomNavigationItem(
                    selected = currentRounte == item.route,
                    onClick = {
                        navController.navigate(item.route){
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId){
                                saveState = true
                            }
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.iconId),
                            contentDescription = null
                        )
                    },

                    /**
                     * Этот код для отоброжения название в bottombar
                     * label = {
                        Text(text = item.title, fontSize = 9.sp)
                    },*/

                    selectedContentColor = UGreen,
                    unselectedContentColor = Color.White
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewBottomBar(){
    BottomNavigation(navController = rememberNavController())
}