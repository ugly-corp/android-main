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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.navigation.ScreenSealed
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.lang.Exception


@Composable
fun AuthScreen(
    navController: NavController
){
    val auth = FirebaseAuth.getInstance()
    //Логин
    val email_state = remember{ mutableStateOf("") }
    //Паорль
    val password_state = remember{ mutableStateOf("") }


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
            text = "Вход",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ){
            Spacer(modifier = Modifier.padding(8.dp))


            OutlinedTextField(
                value = email_state.value,
                onValueChange = {
                    email_state.value = it
                },
                label = {
                    Text(text = "Email")
                },
                shape = RoundedCornerShape(8.dp),
            )



            OutlinedTextField(
                value = password_state.value,
                onValueChange = {
                    password_state.value = it
                },
                label = {
                    Text(text = "Пароль")
                },
                shape = RoundedCornerShape(8.dp)
            )


        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            modifier = Modifier
                .drawBehind {
                    val strokeWidth = 1.dp.toPx()
                    val verticalOffset = size.height - 2.sp.toPx()
                    drawLine(
                        color = Color.Gray,
                        strokeWidth = strokeWidth,
                        start = Offset(0f, verticalOffset),
                        end = Offset(size.width, verticalOffset)
                    )
                },
            text = "Забыли пороль?",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.padding(8.dp))

        //Войти
        Button(
            modifier = Modifier
                .padding(start = 32.dp, end = 32.dp, bottom = 48.dp)
                .fillMaxWidth(),
            onClick = {
                      CoroutineScope(Dispatchers.Main).launch {
                          signInWithEmailAndPassword(auth, email_state, password_state){ success ->
                              if (success){
                                  navController.navigate(route = ScreenSealed.Home.route)
                              }else{

                              }
                          }
                      }
                      },


            colors = ButtonDefaults.buttonColors(UGreen),
        ) {
            Text(
                text = "Войти",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

private suspend fun signInWithEmailAndPassword(
    auth: FirebaseAuth,
    email: MutableState<String>,
    password: MutableState<String>,
    onComplete: (Boolean) -> Unit
){
    try {
        val result = auth.signInWithEmailAndPassword(email.value, password.value).await()
        onComplete(true)
    } catch (e: Exception){
        onComplete(false)
    }
}



@Preview(showBackground = true)
@Composable
fun AuthPreview() {
    Ugly_galleryALPHATheme {
        AuthScreen(navController = rememberNavController())
    }
}