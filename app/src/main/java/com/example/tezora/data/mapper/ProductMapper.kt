package com.example.tezora.data.mapper

import com.example.tezora.data.remote.Dto.ProductDto
import com.example.tezora.domain.model.ProductX
fun ProductDto.toDomain(): ProductX {
    return ProductX(
        id = id,
        title = title ?: "",
        availabilityStatus = if ((stock ?: 0) > 0) "In Stock" else "Out of Stock",
        brand = brand ?: "Unknown",
        category = category ?: "",
        description = description ?: "",
        discountPercentage = discountPercentage ?: 0.0,
        images = images ?: emptyList(),
        minimumOrderQuantity = minimumOrderQuantity ?: 1,
        price = price ?: 0.0,
        rating = rating ?: 0.0,
        returnPolicy = returnPolicy ?: "",
        reviews = reviews ?: emptyList(),
        shippingInformation = shippingInformation ?: "",
        sku = sku ?: "",
        stock = stock ?: 0,
        tags = tags ?: emptyList(),
        thumbnail = thumbnail ?: "",
        warrantyInformation = warrantyInformation ?: "",
        weight = weight ?: 0
    )
}