package com.example.ugly_galleryalpha.Presentation.screens.Home

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.SubcomposeAsyncImage
import com.example.ugly_galleryalpha.Domain.model.Category
import com.example.ugly_galleryalpha.Domain.model.DataXXpost
import com.example.ugly_galleryalpha.Domain.model.User
import com.example.ugly_galleryalpha.Domain.model.postLentaModel
import com.example.ugly_galleryalpha.R
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme
import com.squareup.picasso.Picasso

@Composable
fun LentaPost(model: DataXXpost) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        BoxWithConstraints(
            modifier = Modifier
                .size(370.dp, 400.dp)
                .clickable { // Сделать переход на пост
                }
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                elevation = 8.dp,
                shape = RoundedCornerShape(30.dp)
            ) {

                PicassoImageImage(url = model.photo)

                """""
                Image(
                    painter = painterResource(id = R.drawable.photo4),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                """
            }

            // Наложение UserNameCard поверх Card
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(8.dp)
                    .fillMaxWidth(),
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    UserNameCard(model)
                    LikeLentaPost()
                }

            }

        }
         NamePost(model)
    }
}
@Composable
fun UserNameCard(userName: DataXXpost) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(
                color = Color.Black.copy(alpha = 0.65f), // Прозрачность 30%
                shape = RoundedCornerShape(90.dp) // Мягкие углы
            )
            .padding(16.dp)
    ) {
        Row(
            //modifier = Modifier.size(60.dp)
            verticalAlignment = Alignment.CenterVertically
        ){

            Card(
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(180.dp)
            ){

                //Заменить то что ниже
                PicassoImage(url = userName.user.avatar)
                """""
                Image(
                    painter = painterResource(id = R.drawable.photo4),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                """
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = userName.user.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )



        }
    }
}

@Composable
fun LikeLentaPost(){
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(
                color = Color.Black.copy(alpha = 0.65f), // Прозрачность 65%
                shape = RoundedCornerShape(90.dp) // Мягкие углы
            )
            .padding(16.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.ic_android_black_24dp), contentDescription = null)
    }
}

@Composable
fun NamePost(model: DataXXpost) {
    Column(
        modifier = Modifier
            .fillMaxWidth()  // Заполняем всю ширину родителя
            .padding(8.dp)   // Внешний отступ
    ) {
        // Заголовок поста
        Text(
            text = model.title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Start) // Выравниваем текст по левому краю
        )

        // Описание поста
        Text(
            text = model.description,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Start) // Выравниваем текст по левому краю
        )

        Spacer(modifier = Modifier.padding(20.dp))
    }
}

//Тест пикассо
@Composable
fun PicassoImage(url: String) {
    AndroidView(
        factory = { context ->
            ImageView(context).apply {
                Picasso.get()
                    .load(url)
                    .into(this)
            }
        }
    )
}

@Composable
fun PicassoImageImage(url: String, contentDescription: String? = null, contentScale: ContentScale = ContentScale.Crop) {
    SubcomposeAsyncImage(
        model = url,
        contentDescription = contentDescription,
        contentScale = contentScale,
        //modifier = Modifier.fillMaxSize(), // Модификатор размера, если требуется
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ugly_galleryALPHATheme {

        val photo = painterResource(id = R.drawable.photo4).toString()

        val categories: List<Category> = listOf(
            Category(id = 1, name = "Electronics", photo = photo),
        )

        val user: User = User(
            avatar = photo,
            email = "user123@example.com",
            id = 123,
            name = "John Doe"
        )

        LentaPost(model = DataXXpost(categories, "Hi, it's my first post", 1, photo, "Hello", user, 1))
    }
}