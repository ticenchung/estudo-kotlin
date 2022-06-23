package br.com.luiz.zipcode.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class AddressForm(
    @field:NotEmpty(message = "Street can't be empty.")
    @field:NotBlank(message = "Street must not be blank.")
    val street: String,

    @field:NotEmpty(message = "City can't be empty.")
    @field:NotBlank(message = "City must not be blank.")
    val city: String,

    @field:NotEmpty(message = "State can't be empty.")
    @field:NotBlank(message = "State must not be blank.")
    @field:Size(min = 2, max = 2, message = "State only have 2 letters.")
    val state: String
)