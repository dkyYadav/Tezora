package com.example.tezora.domain.Usecase

import com.example.tezora.Uistate
import com.example.tezora.domain.model.ProductX
import com.example.tezora.domain.repository.ProductRepository

class GetProductUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): Uistate<List<ProductX>>{
        return repository.getproducts()
    }
}