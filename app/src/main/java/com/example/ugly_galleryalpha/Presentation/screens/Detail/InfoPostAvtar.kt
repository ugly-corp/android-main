package com.example.ugly_galleryalpha.Presentation.screens.Detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ugly_galleryalpha.R

@Composable
fun InfoPostAvtar(){
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

            //иконка автора
            Image(
                painter = painterResource(id = R.drawable.photo1),
                contentDescription = (null),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))

        //имя автора
        Text(
            text = "name_artist",
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
