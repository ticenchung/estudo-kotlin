package br.com.luiz.user.dto

import br.com.luiz.user.model.Address
import javax.persistence.Embedded
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NewClientForm(
    @field:NotEmpty(message = "Message cannot be empty.")
    @field:Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters.")
    val name: String,

    @field:NotNull
    @field:Min(value = 18, message = "Sorry. Only above age of 18 can register.")
    val age: Int,

    @Embedded
    val address: Address,

    @field:NotEmpty(message = "Telephone cannot be empty.")
    val telephone: String,

    @field:NotEmpty(message = "E-mail cannot be empty.")
    val email: String,

    @field:NotEmpty(message = "Password cannot be empty.")
    val password: String
)