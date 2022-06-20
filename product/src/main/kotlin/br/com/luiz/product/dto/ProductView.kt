package br.com.luiz.product.dto

import java.math.BigDecimal

class ProductView(
    val id: Long?,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val isActive: Boolean
)
