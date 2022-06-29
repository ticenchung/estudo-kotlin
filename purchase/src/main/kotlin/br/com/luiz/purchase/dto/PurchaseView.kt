package br.com.luiz.purchase.dto

import java.math.BigDecimal

data class PurchaseView(
    val id: String?,
    val idClient: Long,
    val idProduct: Long,
    var quantity: Int,
    var price: BigDecimal,
    var total: BigDecimal
)