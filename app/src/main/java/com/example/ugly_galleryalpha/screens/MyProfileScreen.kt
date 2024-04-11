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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Box(
                modifier = Modifier
                    .size(92.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.CenterVertically)
            ){
                Image(
                    painter = painterResource(id = R.drawable.photo1),
                    contentDescription = (null),
                    contentScale = ContentScale.Crop
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.baseline_create_24),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Bottom)
            )

            Row(){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_share_24),
                    contentDescription = null,
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_notifications_24),
                    contentDescription = null
                )
            }
        }

        MyName(name = "Kirill", info = "I love UG")
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