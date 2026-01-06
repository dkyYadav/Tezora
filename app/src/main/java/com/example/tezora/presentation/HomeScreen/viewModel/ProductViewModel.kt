package com.example.tezora.presentation.HomeScreen.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateSetOf
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

    private val _state = MutableStateFlow<Uistate<List<ProductX>>>(Uistate.Idle)
    val state: StateFlow<Uistate<List<ProductX>>> = _state

    init {
        fetchProduct()
    }
    fun fetchProduct(){
        viewModelScope.launch {
            Log.d("ProductVM", "fetchProducts() called")
            _state.value = Uistate.Loading

            try {
                val product  = getProductUseCase()
                Log.d(
                    "ProductVM",
                    "Products fetched successfully. Size = ${product.size}"
                )

                product.forEach {
                    Log.d("ProductVM", "Product: ${it.title}")
                }

                withContext(Dispatchers.Main) {
                    _state.value = Uistate.Success(product)
                }

            }catch (e: Exception){
                Log.e("ProductVM", "Crash happened", e)

                _state.value = Uistate.Failure(e.message.toString())
            }
        }
    }
}