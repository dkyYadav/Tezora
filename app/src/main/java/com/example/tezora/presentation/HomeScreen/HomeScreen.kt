package com.example.tezora.presentation.HomeScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Card
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tezora.R
import com.example.tezora.presentation.auth.AuthViewModel
import javax.annotation.meta.When


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUI(
    onLogoutClick: () -> Unit
) {


    var selectedIndex by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(5.dp)
                    .height(75.dp),
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
                                modifier = Modifier
                                    .size(40.dp)
                                    .clickable(onClick = { onLogoutClick() })
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = stringResource(R.string.app_name)
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
                    }
                }
            )
        },
        // Bottom Bar
        bottomBar = {
            CustomBottomBar(
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it },
                onCartClick = {
                    // Navigate to Cart Screen
                  selectedIndex = 2
                }
            )
        }
    ) {  innerPadding ->
        when(selectedIndex){
            0-> Screenlist(
                innerPadding = innerPadding
            )
            1-> WishlistScreen()
            2-> CartView()
            3-> searchBar()
            4-> SettingScreen()
        }
    }
}

@Composable
fun Screenlist(innerPadding: PaddingValues, ) {


    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {

        item {
            searchBar()
        }

        item {
            Spacer(modifier = Modifier.height(5.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "All Featured")
                 Spacer(modifier = Modifier.weight(1f))

            }
        }

        // List of Items
        item {
            Catogaries()
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

@Composable
fun Catogaries() {

    val context = LocalContext.current
        LazyRow(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
                .height(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            item{
                Column (
                    modifier = Modifier.padding(5.dp)
                        .clickable(onClick = {
                            Toast.makeText(context, "Not Working", Toast.LENGTH_SHORT).show()
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Card {
                        Image(painter = painterResource(R.drawable.a),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = "Boys",
                        modifier = Modifier,
                        fontWeight = FontWeight.Black
                        )

                }

            }

            item {
                Column (
                    modifier = Modifier.padding(5.dp)
                        .clickable(onClick = {
                            Toast.makeText(context, "Not Working", Toast.LENGTH_SHORT).show()
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Card {
                        Image(painter = painterResource(R.drawable.e),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = "Girls",
                        modifier = Modifier,
                        fontWeight = FontWeight.Black
                    )

                }
            }
            item{
                Column (
                    modifier = Modifier.padding(5.dp)
                        .clickable(onClick = {
                            Toast.makeText(context, "Not Working", Toast.LENGTH_SHORT).show()
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Card {
                        Image(painter = painterResource(R.drawable.d),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = "Kids",
                        modifier = Modifier,
                        fontWeight = FontWeight.Black
                    )

                }

            }

            item {
                Column (
                    modifier = Modifier.padding(5.dp)
                        .clickable(onClick = {
                            Toast.makeText(context, "Not Working", Toast.LENGTH_SHORT).show()
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Card {
                        Image(painter = painterResource(R.drawable.c),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = "Mans",
                        modifier = Modifier,
                        fontWeight = FontWeight.Black
                    )

                }
            }
            item{
                Column (
                    modifier = Modifier.padding(5.dp)
                        .clickable(onClick = {
                            Toast.makeText(context, "Not Working", Toast.LENGTH_SHORT).show()
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Card {
                        Image(painter = painterResource(R.drawable.a),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = "Boys",
                        modifier = Modifier,
                        fontWeight = FontWeight.Black
                    )

                }

            }

            item {
                Column (
                    modifier = Modifier.padding(5.dp)
                        .clickable(onClick = {
                            Toast.makeText(context, "Not Working", Toast.LENGTH_SHORT).show()
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Card {
                        Image(painter = painterResource(R.drawable.e),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = "Girls",
                        modifier = Modifier,
                        fontWeight = FontWeight.Black
                    )

                }
            }
            item{
                Column (
                    modifier = Modifier.padding(5.dp)
                        .clickable(onClick = {
                            Toast.makeText(context, "Not Working", Toast.LENGTH_SHORT).show()
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Card {
                        Image(painter = painterResource(R.drawable.d),
                            contentDescription = null,
                            modifier = Modifier.size(70.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = "Kids",
                        modifier = Modifier,
                        fontWeight = FontWeight.Black
                    )

                }

            }
    }
}

@Composable
fun HomeScreen(authViewModel: AuthViewModel) {
HomeScreenUI(
    onLogoutClick = {
        authViewModel.logout()
    }
)
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
 HomeScreenUI {

 }
}


