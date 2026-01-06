package com.example.tezora.presentation.HomeScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tezora.Uistate
import com.example.tezora.domain.model.ProductX
import com.example.tezora.presentation.HomeScreen.viewModel.AppViewModels
import com.example.tezora.presentation.HomeScreen.viewModel.ProductViewModel

@Composable
fun HomeProduct() {

    val viewModel: ProductViewModel = AppViewModels.productViewModel
    Log.d("UI_CHECK", "HomeProduct composable entered")
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()  // <-- important
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        when (state) {
            is Uistate.Idle -> Text("Nothing")
            is Uistate.Success -> {
                val products = (state as Uistate.Success<List<ProductX>>).data

                LazyColumn(
                    modifier = Modifier.fillMaxSize(), // fill space
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    items(products) { product ->
                        Text(product.title, fontSize = 16.sp)
                    }
                }
            }
            is Uistate.Failure -> Text("Error")
            Uistate.Loading -> CircularProgressIndicator()
        }
    }
}