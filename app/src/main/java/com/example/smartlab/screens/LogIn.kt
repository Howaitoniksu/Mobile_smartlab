package com.example.smartlab.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.smartlab.R
import com.example.smartlab.obj.ShareValues
import com.example.smartlab.ui.theme.green
import com.example.smartlab.viewmodel.ViewModelMain
import androidx.compose.material3.Text as Text


@Composable
fun LogIn(navController: NavHostController, ViewModel: ViewModelMain) {
    var check = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 20.dp),
    ) {
        Row {
            Image(
                contentDescription = "",
                painter = painterResource(id = R.drawable.emojie_hi),
                modifier = Modifier
                    .padding(20.dp, 59.dp)
                    .width(32.dp)
                    .height(32.dp)
            )
            Text(
                text = "Добро пожаловать!", fontSize = 24.sp, fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .padding(top = 59.dp)
            )
        }
        Text(text = "Войдите, чтобы пользоваться функциями приложения", fontSize = 15.sp)

        Text(
            text = "Вход по E-mail",
            color = Color(0xFF7E7E9A),
            modifier = Modifier
                .padding(top = 64.dp)
        )
        OutlinedTextField(
            value = ShareValues.email,
            onValueChange = {ShareValues.email = it
                check.value = true},
            placeholder = { Text(text = "example@mail.ru", color = Color(0xFF7E7E9A)) },
            singleLine = true,

            modifier = Modifier
                .padding(top = 10.dp)
                .width(335.dp)
        )

        Button(
            onClick = {ViewModel.sendCodeToEmail(ShareValues.email)
                navController.navigate("EmailCode") {
                    popUpTo("EmailCode")
                }
                      },
            modifier = Modifier
                .padding(top = 32.dp)
                .height(56.dp)
                .width(335.dp),
            shape = RoundedCornerShape(14.dp),
            enabled = check.value,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF57A9FF)
            )

        )
        {
            Text(
                text = "Далее", fontSize = 24.sp,
                color = Color(0xFFFFFFFF)
            )
        }
        Column(modifier = Modifier
            .fillMaxWidth(),
            )
        {
            Text(text = "Или войдите с помощью", fontSize = 15.sp, color = Color(0xFF7E7E9A), modifier = Modifier
                .padding(top = 238.dp))
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = 16.dp, start = 20.dp)
                    .height(40.dp)
                    .width(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFFFFF)
                )
            )
            {
                Text(
                    "Войти с Яндекс",
                    fontSize = 17.sp,
                    lineHeight = 24.sp,
                    color = Color.Black
                )
            }
        }
    }
}
