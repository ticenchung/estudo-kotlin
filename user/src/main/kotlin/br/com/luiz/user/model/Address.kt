package br.com.luiz.user.model

import javax.persistence.Embeddable

@Embeddable
data class Address(
    val street: String,
    val number: Int,
    val city: String,
    val state: String
)
