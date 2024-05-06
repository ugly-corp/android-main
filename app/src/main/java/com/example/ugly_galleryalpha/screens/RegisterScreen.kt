package com.example.ugly_galleryalpha.screens

import com.example.ugly_galleryalpha.ui.theme.UGreen
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.navigation.ScreenSealed
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.lang.Exception


// Экран регистрации
@Composable
fun RegisterScreen(
    navController: NavController
){
    val auth = FirebaseAuth.getInstance()
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
                val email = emailState.value
                val password = passwordState.value
                val username = loginState.value
                CoroutineScope(Dispatchers.Main).launch {
                    registerWithEmailAndPassword(auth, email, password, username) { success ->
                        if (success) {
                            navController.navigate(ScreenSealed.Home.route)
                        } else {
                            // Обработка ошибок регистрации
                        }
                    }
                }
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

//Функция регистрации

private suspend fun registerWithEmailAndPassword(
    auth: FirebaseAuth,
    email: String,
    password: String,
    username: String,
    onComplete: (Boolean) -> Unit
){
    try {
        val result = auth.createUserWithEmailAndPassword(email, password).await()
        result.user?.updateProfile(UserProfileChangeRequest.Builder()
            .setDisplayName(username)
            .build())
            ?.await()
        onComplete(true)
    } catch (e: Exception){
        onComplete(false)
    }
}


@Composable
@Preview(showBackground = true)
fun RegisterPreview() {
    Ugly_galleryALPHATheme {
        RegisterScreen(navController = rememberNavController())
    }
}