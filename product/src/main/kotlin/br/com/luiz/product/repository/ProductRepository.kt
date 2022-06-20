package br.com.luiz.product.repository

import br.com.luiz.product.model.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {

    fun findByName(productName: String, pagination: Pageable): Page<Product>

}