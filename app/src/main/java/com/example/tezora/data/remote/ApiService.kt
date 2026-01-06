package com.example.tezora.data.remote

import com.example.tezora.Uistate
import com.example.tezora.data.remote.Dto.ProductResponseDto
import com.example.tezora.domain.model.ProductX
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiService {

    @GET("products")
   suspend fun getProducts(
        @Query("limit") limit: Int = 0)
   : ProductResponseDto
}