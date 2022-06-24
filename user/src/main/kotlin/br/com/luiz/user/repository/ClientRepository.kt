package br.com.luiz.user.repository

import br.com.luiz.user.model.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<Client, Long> {
    fun findByEmail(email: String): Client?

}