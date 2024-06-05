package com.example.ugly_galleryalpha.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.R
import com.example.ugly_galleryalpha.navigation.ScreenSealed
import com.example.ugly_galleryalpha.ui.theme.UGreen
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme
import com.google.firebase.auth.FirebaseAuth

@Composable
fun MyProfileScreen(navController: NavController, username: String){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(modifier = Modifier.padding(10.dp))
        Box(
            modifier = Modifier
                .height(170.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.align(Alignment.Center)
            ) {
                Box(
                    modifier = Modifier.size(130.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.photo1),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(shape = CircleShape))
                }
            }

            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 10.dp, top = 10.dp)
            ) {
                Box(
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(
                        painterResource(id = R.drawable.baseline_create_24),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(painterResource(id = R.drawable.baseline_create_24),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize())
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp, bottom = 10.dp)
            ) {
                Box(
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(painterResource(id = R.drawable.baseline_create_24),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize())
                }
            }
        }

        MyName(name = username, info = "{$username}_info")
        ButtonSettingandHelp(navController = navController)



    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom

    ){
        add_photo()
    }



}


//Имя и описание
@Composable
fun MyName(name: String, info: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Имя
        Text(
            text = name,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )

        //Описание
        Text(
            text = info,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.padding(8.dp))

    }
}

//Кнопки Настройки && Помощь
@Composable
fun ButtonSettingandHelp(navController: NavController){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        //Настройки кнопка ->
        Button(
            onClick = {
                navController.navigate(ScreenSealed.UserSettings.route)
            },
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.size(height = 22.dp, width = 128.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(36.dp)
        ) {
            Text(
                fontSize = 12.sp,
                text = "Настройка",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.padding(start = 100.dp))

        //Помощь кнопка ->
        Button(
            modifier = Modifier
                .defaultMinSize(minHeight = 1.dp, minWidth = 1.dp)
                .size(height = 22.dp, width = 128.dp),
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray),
            shape = RoundedCornerShape(36.dp)

        ) {

            Text(
                fontSize = 12.sp,
                text = "Помощь",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

        }
    }
}

//Добавление фото
@Composable
fun add_photo(){
    Button(
        colors = ButtonDefaults.buttonColors(Color.Black),
        onClick = { /*TODO*/ },
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(46.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_add_24),
            contentDescription = "add photo",
            tint = Color.White,
            modifier = Modifier.size(35.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun MyProfilePreview() {
    Ugly_galleryALPHATheme {
        MyProfileScreen(navController = rememberNavController(), username = "User")
    }
}