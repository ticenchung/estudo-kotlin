package br.com.luiz.user.dto

import br.com.luiz.user.model.Address
import javax.persistence.Embedded

data class NewClientForm(
    val name: String,
    val age: Int,
    @Embedded
    val address: Address,
    val telephone: String,
    val email: String,
    val password: String
)