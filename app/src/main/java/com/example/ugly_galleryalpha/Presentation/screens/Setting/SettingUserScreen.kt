package com.example.ugly_galleryalpha.Presentation.screens.Setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

@Composable
fun SettingUserScreen(
    navController: NavController
){
    Column(){
        Text(
            modifier = Modifier.padding(16.dp),
            text = "< Назад",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = "Настройки",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            //verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            NameUserInput()
            IdUserInput()
            DescripUserInput()
            WebSaiteUserInput()
        }
    }
}

@Composable
fun NameUserInput(){
    //Логин
    val email_state = remember{ mutableStateOf("") }

    OutlinedTextField(
        value = email_state.value,
        onValueChange = {
            email_state.value = it
        },
        label = {
            Text(text = "Имя пользователя")
        },
        shape = RoundedCornerShape(8.dp),
    )
}

@Composable
fun IdUserInput(){
    //Логин
    val email_state = remember{ mutableStateOf("") }

    OutlinedTextField(
        value = email_state.value,
        onValueChange = {
            email_state.value = it
        },
        label = {
            Text(text = "id")
        },
        shape = RoundedCornerShape(8.dp),
    )
}

@Composable
fun DescripUserInput(){
    //Логин
    val email_state = remember{ mutableStateOf("") }

    OutlinedTextField(
        value = email_state.value,
        onValueChange = {
            email_state.value = it
        },
        label = {
            Text(text = "Сведения о себе")
        },
        shape = RoundedCornerShape(8.dp),
    )
}

@Composable
fun WebSaiteUserInput(){
    //Логин
    val email_state = remember{ mutableStateOf("") }

    OutlinedTextField(
        value = email_state.value,
        onValueChange = {
            email_state.value = it
        },
        label = {
            Text(text = "Веб-сайт")
        },
        shape = RoundedCornerShape(8.dp),
    )
}

@Preview(showBackground = true)
@Composable
fun SettingUserScreenPreview() {
    Ugly_galleryALPHATheme {
        SettingUserScreen(rememberNavController())
    }
}