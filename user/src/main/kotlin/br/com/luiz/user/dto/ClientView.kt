package br.com.luiz.user.dto

data class ClientView(
    val id: Long?,
    val name: String,
    val telephone: String,
    val email: String,
    val isActive: Boolean
)