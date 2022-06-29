package br.com.luiz.purchase.config

import br.com.luiz.purchase.exception.FeignExceptionDecoder
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["br.com.luiz.purchase.integration.feign.client"])
class FeignConfig {

    @Bean
    fun errorDecoder(): FeignExceptionDecoder? = FeignExceptionDecoder()

}