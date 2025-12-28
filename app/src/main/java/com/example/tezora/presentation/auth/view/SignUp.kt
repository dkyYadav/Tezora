package com.example.tezora.presentation.auth.view

import android.widget.Toast
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
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tezora.Uistate
import com.example.tezora.navigation.Routes
import com.example.tezora.presentation.auth.AuthViewModel


@Composable
fun SignUp(
    navHostController: NavHostController,
    authViewModel: AuthViewModel
) {

    val context = LocalContext.current
    var userEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var Repassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Observe auth state
    val authState by authViewModel.authState.collectAsState()

    // Handle navigation after successful signup
    LaunchedEffect(authState) {
        when(authState){
            is Uistate.Failure -> {
                errorMessage = (authState as Uistate.Failure).error
            }
            is Uistate.Success-> {
                navHostController.navigate(Routes.Login) {
                    popUpTo(Routes.Signup){inclusive = true}
                }
                Toast.makeText(context, ("Successful"), Toast.LENGTH_SHORT).show()
            }

            else -> {}
        }
    }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(25.dp),
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))



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
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))



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
                    painter = painterResource(R.drawable.ic_eye),
                    contentDescription = "eye",
                    modifier = Modifier.size(24.dp),
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "By clicking the Register button, you agree to the public offer",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            fontSize = 16.sp,
            )

        Spacer(modifier = Modifier.height(30.dp))

        // Error Message if pass not matched
        if (errorMessage != null){
            Text(text = errorMessage ?: "",
                color = Color.Red,
                fontSize = 14.sp)
        }

        Button(onClick = {
        // on button click
            if (password != Repassword){
                errorMessage = "Password do not Match"
            }else{
                authViewModel.signup(userEmail,password)
            }
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
                .heightIn(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults
                .buttonColors(containerColor = colorResource(R.color.main_Color) )

        ) {
            Text("Create Account",
                color = Color.Black)
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "- OR Continue with -", modifier = Modifier, fontSize = (20.sp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            OutlinedButton(onClick = {},
                modifier = Modifier.height(50.dp)
            ) { Icon(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "Facebook",
                tint = Color.Unspecified,
                modifier = Modifier.size(50.dp))

                Spacer(modifier = Modifier.width(5.dp))
                Text(text = " Facebook "
                    , color = Color.Black)
            }

            Spacer(modifier = Modifier.width(15.dp))

            OutlinedButton ( onClick = {},
                modifier = Modifier.height(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google)
                    , contentDescription = "Google",
                    tint = Color.Unspecified,
                    modifier = Modifier.padding(start = 5.dp)

                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "  Google  ",
                    modifier = Modifier.padding(5.dp)
                    ,color = Color.Black)
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
                text = "Login",
                color = colorResource(R.color.main_Color),
                modifier = Modifier.clickable {
                   navHostController.navigate(Routes.Login)
                 }, fontSize = 20.sp

            )
        }

    }

}