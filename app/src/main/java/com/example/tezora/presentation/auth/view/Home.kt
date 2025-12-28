package com.example.tezora.presentation.auth.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tezora.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUI(

) {

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(75.dp)
                    .padding(
                        horizontal = 10.dp
                    ),
                title = {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            verticalAlignment = Alignment.CenterVertically,

                        ) {
                            //start menu
                            Icon(
                                painter = painterResource(R.drawable.ic_menu),
                                contentDescription = "menu",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(40.dp)
                            )

                            Spacer(modifier = Modifier.weight(1f))
                            // end profile icon

                            Icon(
                               painter =  painterResource(id = R.drawable.ic_profile),
                                contentDescription = "profile",
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(end = 4.dp),
                                tint = Color.Unspecified
                            )
                        }
                        // center logo

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.app_logo),
                                contentDescription = "logo",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = stringResource(R.string.app_name))

                        }
                    }

                }

            )
        },

    ) {  innerPadding ->
        Screenlist(
            innerPadding = innerPadding
        )
    }
}

@Composable
fun Screenlist(innerPadding: PaddingValues, ) {
    LazyColumn (
            modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
     ){

        item{
            searchBar()
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "All Featured"
                )
            }

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                 /*   Card(
                        modifier = Modifier.padding(5.dp),
                        shape = RoundedCornerShape(50.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {

                    }
                */

            }
        }

    }
}
@Composable
fun searchBar(){
var searchText by remember { mutableStateOf("") }

    TextField(
        value = searchText,
        onValueChange = {searchText = it},
        placeholder = {Text("Search...")},
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        singleLine = true,



    )
}

@Preview(showBackground = true)
@Composable
fun Home() {

    HomeScreenUI()
}


