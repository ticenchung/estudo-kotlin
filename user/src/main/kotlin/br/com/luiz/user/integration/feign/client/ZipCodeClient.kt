package br.com.luiz.user.integration.feign.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "ZipCodeAPI", url = "\${integration.zipCode.url}")
interface ZipCodeClient {

    @PostMapping
    fun generateZipCode(@RequestBody form: AddressFormClient): String

}