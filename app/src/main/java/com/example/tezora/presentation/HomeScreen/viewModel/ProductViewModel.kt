package com.example.tezora.presentation.HomeScreen.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tezora.Uistate
import com.example.tezora.domain.Usecase.GetProductUseCase
import com.example.tezora.domain.model.ProductX
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
 // your package name



object AppViewModels {
    lateinit var productViewModel: ProductViewModel
}


class ProductViewModel(
    private val getProductUseCase: GetProductUseCase
) : ViewModel(){

    private val _productsState =
        MutableStateFlow<Uistate<List<ProductX>>>(Uistate.Idle)
    val productsState: StateFlow<Uistate<List<ProductX>>> = _productsState

    init {
        fetchProduct()
    }
    fun fetchProduct(){
        Log.d("ProductViewModel", "fetchProducts() called")
        _productsState.value = Uistate.Loading
        viewModelScope.launch {
            try {
                val result  = getProductUseCase()
                Log.d("ProductViewModel","Products fetched successfully. Size = ${result}\n")
                _productsState.value = result
            }catch (e: Exception){
                Log.e("ProductViewModel", "Error loading products: ${e.message}", e)
                _productsState.value = Uistate.Failure(e.message ?: "Unknown error")
            }
        }
    }

    fun retryLoading(){
        fetchProduct()
    }
}