package com.example.tezora.presentation.auth.view



import com.example.tezora.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tezora.navigation.Routes

@Composable
fun splash_screen(navController: NavHostController) {

    Column ( modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box(
            modifier = Modifier.fillMaxWidth().background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.app_logo),
                contentDescription = "splash screen",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                navController.navigate(Routes.Login) {
                    popUpTo(Routes.Splash) { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
                .heightIn(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults
                .buttonColors(containerColor = colorResource(R.color.main_Color) )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Next",
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = "Next",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}