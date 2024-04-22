package com.example.ugly_galleryalpha.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.R
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

@Composable
fun MyProfileScreen(){
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

        MyName(name = "User", info = "User_info")
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

        ButtonSettingandHelp()
    }
}

//Кнопки Настройки && Помощь
@Composable
fun ButtonSettingandHelp(){
    Row(){

        //Настройки кнопка ->
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Найстройка")
        }

        //Помощь кнопка ->
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Помошь")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyProfilePreview() {
    Ugly_galleryALPHATheme {
        MyProfileScreen()
    }
}