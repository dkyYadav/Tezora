package com.example.tezora.view

import androidx.compose.foundation.clickable
import com.example.tezora.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tezora.navigation.Routes
import java.nio.file.WatchEvent

@Composable
fun SignUp(navHostController: NavHostController) {

    Column (modifier = Modifier.fillMaxSize().padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Create an account",
            modifier = Modifier,
            fontSize = 53.sp,
            )
        Spacer(modifier = Modifier.height(15.dp))

       var userEmail by remember { mutableStateOf("") }

        OutlinedTextField(
            value = userEmail,
            onValueChange = {userEmail =it},
            label = {
             Text(  text =  "Username or Email",
                 modifier = Modifier, fontSize = 16.sp)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email"
                )
            },
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = password,
            onValueChange = {
                password =it},
            label = {
                Text(  text =  "Password",
                    modifier = Modifier, fontSize = 16.sp)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "password"
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_eye),
                    contentDescription = "eye",
                    modifier = Modifier.size(24.dp),
                )
            },
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        var Repassword by remember { mutableStateOf("") }

        OutlinedTextField(
            value = Repassword,
            onValueChange = {
                Repassword =it},
            label = {
                Text(  text =  "Password",
                    modifier = Modifier, fontSize = 16.sp)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "password"
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(com.example.tezora.R.drawable.ic_eye),
                    contentDescription = "eye",
                    modifier = Modifier.size(24.dp),
                )
            },
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "By clicking the Register button, you agree to the public offer",
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            fontSize = 16.sp,
            )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {},
            modifier = Modifier.fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
                .heightIn(50.dp),
            shape = RoundedCornerShape(10.dp)

        ) {
            Text("Create Account")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "- OR Continue with -", modifier = Modifier, fontSize = (20.sp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Icon(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "google",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(id=R.drawable.img_1),
                contentDescription = "facebook",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(R.drawable.ic_apple)
                , contentDescription = "apple",
                modifier = Modifier.size(50.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Text(
                text = "Create An Account",
                modifier = Modifier, fontSize = 20.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Login",
                color = colorResource(R.color.purple_200),
                modifier = Modifier.clickable {

                navHostController.navigate(Routes.Login)
                 }, fontSize = 20.sp

            )
        }

    }

}