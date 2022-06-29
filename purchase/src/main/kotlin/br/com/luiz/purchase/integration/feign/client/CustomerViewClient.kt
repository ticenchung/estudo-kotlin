package br.com.luiz.purchase.integration.feign.client

class CustomerViewClient(
    val id: Long?,
    val name: String,
    val telephone: String,
    val email: String
)