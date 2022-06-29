package br.com.luiz.purchase.integration.feign.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "CustomerAPI", url = "\${integration.customer.url}")
interface CustomerClient {

    @GetMapping("/clients/{id}")
    fun findCustomer(@PathVariable id: Long): CustomerViewClient

}