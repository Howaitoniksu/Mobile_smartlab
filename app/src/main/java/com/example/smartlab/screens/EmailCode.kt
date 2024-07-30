package com.example.smartlab.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.smartlab.R
import com.example.smartlab.obj.ShareValues
import com.example.smartlab.viewmodel.ViewModelMain

@Composable
fun EmailCode(navController: NavHostController, ViewModel: ViewModelMain) {
    val focusManager = LocalFocusManager.current
    val (codePart1, setCodePart1) = remember {
        mutableStateOf("")
    }
    val (codePart2, setCodePart2) = remember {
        mutableStateOf("")
    }
    val (codePart3, setCodePart3) = remember {
        mutableStateOf("")
    }
    val (codePart4, setCodePart4) = remember {
        mutableStateOf("")
    }

    LaunchedEffect(codePart1) {
        if (codePart1 != "") {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next
            )
        }
    }
    LaunchedEffect(codePart2) {
        if (codePart2 != "") {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next
            )
        }
    }
    LaunchedEffect(codePart3) {
        if (codePart3 != "") {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next
            )
        }
    }
    LaunchedEffect(codePart4) {
        if (codePart1 != "" && codePart2 != "" && codePart3 != "" && codePart4 != "") {
            ViewModel.SignIn((codePart1 + codePart2 + codePart3 + codePart4), ShareValues.email)
            focusManager.clearFocus()
        }
    }
    LaunchedEffect( ViewModel.codeBoolean) {
        if (ViewModel.codeBoolean) {
            navController.navigate("Catalog") {
                popUpTo("EmailCode") {
                    inclusive = true
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Button(
            onClick = {
                navController.navigate("LogInScreen") {
                    popUpTo("LogInScreen")
                }
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(top = 24.dp, start = 20.dp)
                .height(32.dp)
                .width(32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEEEEEE),
            )

        ) {
            Image(
                painter = painterResource(id = R.drawable.backscreen_arrow),
                contentDescription = null,
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .zIndex(3f)
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 80.dp)
        ) {
            Text(
                text = "Введите код из E-mail",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 132.dp),
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(700)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 68.dp, top = 24.dp, end = 68.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextFieldWithCode(codePart1, setCodePart1)
            TextFieldWithCode(codePart2, setCodePart2)
            TextFieldWithCode(codePart3, setCodePart3)
            TextFieldWithCode(codePart4, setCodePart4)
        }

        Row {
            Text(
                modifier = Modifier
                    .padding(start = 68.dp, top = 20.dp),
                textAlign = TextAlign.Center,
                text = "Отправить код повторно можно\nбудет через 60 секунд",
                fontSize = 15.sp,
                color = Color(0xFF939396),
                lineHeight = 20.sp
            )
        }
    }
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TextFieldWithCode(codePart: String, setCodePart: (String) -> Unit) {
        OutlinedTextField(
            value = codePart,
            onValueChange = {
                if (it.length == 2 && it.isNotEmpty()) setCodePart(it.substring(1))
                else setCodePart(it)
            },
            modifier = Modifier
                .width(48.dp)
                .height(48.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFF5F5F9),
                focusedBorderColor = Color(0xFF535353),
                unfocusedBorderColor = Color(0xFFF5F5F9),
            ),
            shape = RoundedCornerShape(13.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            textStyle = TextStyle(
                lineHeight = 28.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
            ),
        )
    }