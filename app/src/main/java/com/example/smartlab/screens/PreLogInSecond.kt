package com.example.smartlab.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartlab.R
import kotlinx.coroutines.delay


@Composable
@SuppressLint("RememberReturnType")
fun PreLogInSecond(navController: NavHostController) {
      LaunchedEffect(key1 = true) {
          delay(4500L)
          navController.navigate("PreLogInThird") {
              popUpTo("PreLogInSecond")
              {
                  inclusive = true
              }
          }
      }
    Column(
        modifier = Modifier
            .height(20.dp)
            .width(100.dp)
            .fillMaxSize(),
    )
    {
        Button(
            onClick = { navController.navigate("PreLogInThird"){
            popUpTo("PreLogInSecond")
            {
                inclusive = true
            }
        }
            },
            modifier = Modifier
                .padding(top = 5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF)
            )
        )
        {
            Text(
                text = "Пропустить", fontSize = 24.sp,
                color = Color(0xFF57A9FF)
            )
        }
        Column {
            Image(
                painter = painterResource(id = R.drawable.plusicon),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 200.dp)
                    .width(167.04.dp)
                    .height(163.11.dp)

            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    )
    {
        Text(
            text = "Уведомления", fontSize = 20.sp,
            color = Color(0xFF00B712),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Вы быстро узнаете о результатах", fontSize = 14.sp,
            color = Color(0xFF939396),
            modifier = Modifier
                .padding(0.dp, 29.dp),
            textAlign = TextAlign.Center

        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 500.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(id = R.drawable.progress_bar_prelogin2),
            contentDescription = "",
            modifier = Modifier
                .width(58.dp)
                .height(14.29.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.prelogin2),
            contentDescription = "",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )
    }
}