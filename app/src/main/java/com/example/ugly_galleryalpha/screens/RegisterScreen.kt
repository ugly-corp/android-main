package com.example.ugly_galleryalpha.screens

import com.example.ugly_galleryalpha.ui.theme.UGreen
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.example.ugly_galleryalpha.navigation.ScreenSealed



// Экран регистрации
@Composable
fun RegisterScreen(
    navController: NavController
){

    // Логин
    val loginState = remember { mutableStateOf("") }
    // Email
    val emailState = remember { mutableStateOf("") }
    // Пароль
    val passwordState = remember { mutableStateOf("") }

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
            text = "Создайте аккаунт",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ){
            Spacer(modifier = Modifier.padding(16.dp))
            LoginInput(loginState)
            Spacer(modifier = Modifier.padding(8.dp))
            EmailInput(emailState)
            Spacer(modifier = Modifier.padding(8.dp))
            PasswordInput(passwordState)
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(
            onClick = {
                navController.navigate(ScreenSealed.Home.route)

            },
            colors = ButtonDefaults.buttonColors(UGreen),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, bottom = 48.dp)

        ) {
            Text(
                text = "Создать",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}




@Composable
fun LoginInput(loginState: MutableState<String>){
    OutlinedTextField(
        value = loginState.value,
        onValueChange = { loginState.value = it },
        label = { Text(text = "Имя пользователя") },
        shape = RoundedCornerShape(8.dp)
    )
}

@Composable
fun EmailInput(emailState: MutableState<String>){
    OutlinedTextField(
        value = emailState.value,
        onValueChange = { emailState.value = it },
        label = { Text(text = "Email") },
        shape = RoundedCornerShape(8.dp),
    )
}

@Composable
fun PasswordInput(passwordState: MutableState<String>){
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = { Text(text = "Пароль") },
        shape = RoundedCornerShape(8.dp)
    )
}




@Composable
@Preview(showBackground = true)
fun RegisterPreview() {
    Ugly_galleryALPHATheme {
        RegisterScreen(navController = rememberNavController())
    }
}