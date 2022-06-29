package br.com.luiz.purchase.integration.feign.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "ProductAPI", url = "\${integration.product.url}")
interface ProductClient {

    @GetMapping("/products/{id}")
    fun findProduct(@PathVariable id: Long): ProductViewClient

}