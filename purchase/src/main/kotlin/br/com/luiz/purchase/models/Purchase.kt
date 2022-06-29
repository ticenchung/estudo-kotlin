package br.com.luiz.purchase.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(collection = "purchases")
data class Purchase(
    @Id
    val id: String? = null,
    var idClient: Long,
    val idProduct: Long,
    var quantity: Int = 0,
    var price: BigDecimal = BigDecimal.ZERO,
    var total: BigDecimal = BigDecimal.ZERO
)