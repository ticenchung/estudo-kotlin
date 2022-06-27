package br.com.luiz.user.integration.feign.client

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class AddressFormClient(
    val street: String,
    val city: String,
    val state: String
)