package br.com.luiz.product.repository

import br.com.luiz.product.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>