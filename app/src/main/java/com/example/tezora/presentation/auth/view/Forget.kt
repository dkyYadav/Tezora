package com.example.tezora.presentation.auth.view

import com.example.tezora.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tezora.navigation.Routes


@Composable
fun Forget(navHostController: NavHostController) {

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
       IconButton(
            onClick = {
                navHostController.navigate(Routes.Login)
            },
            modifier = Modifier
                .padding(start = 20.dp, top = 40.dp)
                .align(Alignment.Start)
           ) {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "Back",
                modifier = Modifier.size(52.dp)
            )
           }


        Text(text = "Forgot password?",
            modifier = Modifier.padding(30.dp)
                .padding(top = 0.dp)
                ,fontSize = 55.sp
        )

        Column (modifier = Modifier.fillMaxSize().padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

        ){
            var forget by remember { mutableStateOf("") }

            OutlinedTextField(
                value = forget,
                onValueChange = {
                    forget = it
                },
                label = {
                    Text("Enter your email address")
                },
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email"
                    )
                }

            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "We will send you a message to set or reset your new password",
                modifier = Modifier, fontSize = 20.sp

            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {},
                modifier = Modifier.height(50.dp).fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
                ,colors = ButtonDefaults
                        .buttonColors(containerColor = colorResource(R.color.main_Color) )

            ) {
                Text(
                    text = " Submit ",
                    color = Color.Black
                )
            }
        }
    }
}

