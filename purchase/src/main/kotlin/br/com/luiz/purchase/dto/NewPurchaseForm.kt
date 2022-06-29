package br.com.luiz.purchase.dto

data class NewPurchaseForm(
    val idClient: Long,
    val idProduct: Long,
    var quantity: Int
)