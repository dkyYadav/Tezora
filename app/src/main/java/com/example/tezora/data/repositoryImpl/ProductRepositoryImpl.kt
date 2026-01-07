package com.example.tezora.data.repositoryImpl

import com.example.tezora.Uistate
import com.example.tezora.data.mapper.toDomain
import com.example.tezora.data.remote.ProductApiService
import com.example.tezora.domain.model.ProductX
import com.example.tezora.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val api: ProductApiService,
) : ProductRepository{

    // ager jab bhi State ke ke sath data pass karna hai to repo impl me aapko try ka used karna hoga becuse thats helps to check error and success
    override suspend fun getproducts(limit: Int): Uistate<List<ProductX>>{
        return try {
            val products = api.getProducts(limit)
                .products
                .map { it.toDomain() }

            Uistate.Success(products)

        } catch (e: Exception) {
            Uistate.Failure(e.message ?: "RepositoryImpl error")
        }
    }
}