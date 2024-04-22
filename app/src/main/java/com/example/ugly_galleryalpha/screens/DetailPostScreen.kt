package com.example.ugly_galleryalpha.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.R
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

@Composable
fun DetailPostScreen(
    navController: NavController
){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(modifier = Modifier.padding(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "Название работы",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
                )

            Button(onClick = { /*TODO*/ }) {

            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
        ){
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(shape = CircleShape)
            ){
                Image(
                    painter = painterResource(id = R.drawable.photo1),
                    contentDescription = (null),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "Имя автора",
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Spacer(modifier = Modifier.padding(top = 40.dp))
        Box(
            modifier = Modifier
                .size(307.dp)
                .background(color = Color.Gray, shape = RoundedCornerShape(16.dp))
                .align(Alignment.CenterHorizontally)
        ){
            
        }

        Spacer(modifier = Modifier.padding(8.dp))
        Text(modifier = Modifier.padding(start = 48.dp, end = 48.dp),
            text = "Описание")

    }
}

@Preview(showBackground = true)
@Composable
fun DetailPostPreview() {
    Ugly_galleryALPHATheme {
        DetailPostScreen(rememberNavController())
    }
}