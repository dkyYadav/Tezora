package com.example.tezora.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
@Preview(showSystemUi = true)
fun Home() {

   /* Scaffold(
        topBar = {
            TopAppBar(title = { Text("My App") })
        },
        bottomBar = {
            BottomAppBar {
                Text("Bottom Bar", modifier = Modifier.padding(16.dp))
            }
        }
    )*/
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

        }


    ) { innerpading ->

        Column(modifier = Modifier.padding(innerpading).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "THIS IS HOME ACTIVITY",
                modifier = Modifier, fontSize = 25.sp
            )
        }
    }
}