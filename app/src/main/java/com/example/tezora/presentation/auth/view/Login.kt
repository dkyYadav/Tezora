package com.example.tezora.presentation.auth.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tezora.R
import com.example.tezora.Uistate
import com.example.tezora.navigation.Routes
import com.example.tezora.presentation.auth.AuthViewModel

@Composable
//@Preview(showBackground = true)
fun Login(navHostController: NavHostController,
          authViewModel: AuthViewModel
) {

    var useremail by remember() { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    val authState by authViewModel.authState.collectAsState()

    LaunchedEffect(authState) {
        when(val currentState = authState){
            is Uistate.Failure -> {
                showError = true
                errorMessage = currentState.error
            }
            is Uistate.Success-> {
                navHostController.navigate(Routes.Home){
                    popUpTo(Routes.Login) {inclusive = true}
                }
            }
            else -> {}
        }
    }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(start = 25.dp, end = 25.dp, top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Box(modifier = Modifier.padding(bottom = 30.dp)
        ){
            Text(
                text = "Welcome Back!", fontSize = 55.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            value = useremail,
            onValueChange = { useremail = it },
            label = {
                Text("Username or Email")
            },
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),

            leadingIcon = {
                Icon(imageVector = Icons.Default.Email,
                    contentDescription = "Email")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))



        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "lock"
                )
            },
            trailingIcon = {
                Icon(
                    painterResource(R.drawable.ic_eye),
                    contentDescription = "Eye"

                )
            }

        )
        Spacer(modifier = Modifier.height(10.dp))

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End){
            Text("Forgot Password? ",
                modifier = Modifier.clickable {
                    navHostController.navigate(Routes.Forget)
                }, color = colorResource(R.color.main_Color))
        }

        Spacer(modifier = Modifier.height(20.dp))

        // show Error msg
        if (showError){
            Text(
                text =  errorMessage,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Button( onClick = {
            // button on click
            if (useremail.isNotBlank() && password.isNotBlank()){
                authViewModel.Login(useremail,password)
            }
        },
            modifier = Modifier.height(50.dp).fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults
                .buttonColors(containerColor = colorResource(R.color.main_Color) )

        ) {
            if (authState is Uistate.Loading){
                CircularProgressIndicator(
                    color = Color.White,
                    strokeWidth = 2.dp
                )
            }else {
                Text(
                    " Login ",
                    color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "- OR Continue with -", modifier = Modifier, fontSize = 15.sp
        )


        Spacer(modifier = Modifier.height(25.dp))

        Row {
            OutlinedButton(onClick = {},
                modifier = Modifier.height(50.dp)
            ) { Icon(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "Facebook",
                tint = Color.Unspecified
                )

                Spacer(modifier = Modifier.width(5.dp))
                Text(text = " Facebook "
                    , color = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            OutlinedButton ( onClick = {},
                modifier = Modifier.height(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google)
                    , contentDescription = "Google",
                    tint = Color.Unspecified,// original color of image
                    modifier = Modifier.padding(start = 5.dp)

                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "  Google  ",
                    modifier = Modifier.padding(5.dp)
                        , color = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Text(
                text = "Create An Account",
                modifier = Modifier, fontSize = 20.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Sign Up",
                color = colorResource(R.color.main_Color),
                modifier = Modifier.clickable {
                    navHostController.navigate(Routes.Signup)
                }, fontSize = 20.sp
            )
        }




    }
}