package br.com.luiz.product.dto

import java.math.BigDecimal
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class NewProductForm(
    @field:NotEmpty(message = "Name cannot be empty.")
    @field:Size(min = 4, max = 20, message = "Name must be between 4 and 20 characters.")
    val name: String,

    @field:Min(value = 1, message = "The product must have at least 1 quantity.")
    val quantity: Int,

    @field:DecimalMin("0.01", message = "Please enter the price of the product.")
    val price: BigDecimal,

    @field:NotEmpty(message = "Name cannot be empty.")
    @field:Size(min = 4, max = 255, message = "Description must be between 4 and 255 characters.")
    val description: String
)
