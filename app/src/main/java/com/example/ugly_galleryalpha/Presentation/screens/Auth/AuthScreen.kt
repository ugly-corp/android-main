
package com.example.ugly_galleryalpha.Presentation.screens.Auth

import androidx.compose.foundation.background
import com.example.ugly_galleryalpha.ui.theme.UGreen
import com.example.ugly_galleryalpha.ui.theme.Ugly_galleryALPHATheme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ugly_galleryalpha.Presentation.navigation.ScreenSealed
import com.example.ugly_galleryalpha.ui.theme.UGBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    navController: NavController
){
    Box(
        modifier = Modifier.background(UGBlack)
    ) {
        // Логин
        val emailState = remember { mutableStateOf("") }
        // Пароль
        val passwordState = remember { mutableStateOf("") }

        Column() {
            Spacer(modifier = Modifier.padding(24.dp))
            Text(
                modifier = Modifier.padding(25.dp),
                text = "<",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Text(
                modifier = Modifier.padding(start = 25.dp),
                text = "Вход",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.padding(8.dp))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp),
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    label = {
                        Text(
                            text = "Email",
                            color = Color.Gray,
                        )
                    },
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        cursorColor = Color.Black,
                        focusedBorderColor = UGreen,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.Black,
                    )
                )


                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp),
                    value = passwordState.value,
                    onValueChange = {
                        passwordState.value = it
                    },
                    label = {
                        Text(
                            text = "Пароль",
                            color = Color.Gray
                        )
                    },
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        cursorColor = Color.Black,
                        focusedBorderColor = UGreen,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Color.Black,
                    )
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                text = "Забыли пароль?",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Button(
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp, bottom = 48.dp)
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate(route = ScreenSealed.Home.route)
                },
                colors = ButtonDefaults.buttonColors(UGreen)
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
}

@Preview(showBackground = true)
@Composable
fun AuthPreview() {
    Ugly_galleryALPHATheme {
        AuthScreen(navController = rememberNavController())
    }
}

