package br.com.luiz.product.dto

import java.math.BigDecimal

data class ProductUpdateView(
    val id: Long?,
    val name: String,
    val description: String,
    val quantity: Int,
    val price: BigDecimal
)