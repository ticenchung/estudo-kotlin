package br.com.luiz.user.model

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val age: Int,
    @Embedded
    val address: Address,
    val telephone: String,
    val email: String,
    val password: String,
    val isActive: Boolean = true
)