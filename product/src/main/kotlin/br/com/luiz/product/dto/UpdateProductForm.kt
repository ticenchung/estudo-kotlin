package br.com.luiz.product.dto

import java.math.BigDecimal

data class UpdateProductForm(
    val name: String,
    val quantity: Int,
    val price: BigDecimal,
    val description: String
)
