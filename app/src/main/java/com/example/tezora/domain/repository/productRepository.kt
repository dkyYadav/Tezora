package com.example.tezora.domain.repository

import com.example.tezora.Uistate
import com.example.tezora.domain.model.ProductX

interface ProductRepository {
    suspend fun getproducts(limit: Int = 0): List<ProductX>
}