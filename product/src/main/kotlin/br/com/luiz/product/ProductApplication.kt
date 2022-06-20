package br.com.luiz.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ProductApplication

fun main(args: Array<String>) {
	runApplication<ProductApplication>(*args)
}
