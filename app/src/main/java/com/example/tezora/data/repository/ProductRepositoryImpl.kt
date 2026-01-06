package com.example.tezora.data.repository

import com.example.tezora.Uistate
import com.example.tezora.data.mapper.toDomain
import com.example.tezora.data.remote.ProductApiService
import com.example.tezora.domain.model.ProductX
import com.example.tezora.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val api: ProductApiService,
) : ProductRepository{

    override suspend fun getproducts(limit: Int): List<ProductX>{
        return api.getProducts(limit)
            .products.map { it.toDomain() }
    }
}