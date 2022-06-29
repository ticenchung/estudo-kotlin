package br.com.luiz.purchase.integration.feign.client

import java.math.BigDecimal

class ProductViewClient(
    val id: Long?,
    val name: String,
    val description: String,
    val quantity: Int,
    val price: BigDecimal
)