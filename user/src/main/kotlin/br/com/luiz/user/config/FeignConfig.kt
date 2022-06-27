package br.com.luiz.user.config

import br.com.luiz.user.exception.FeignExceptionDecoder
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["br.com.luiz.user.integration.feign.client"])
class FeignConfig {

    @Bean
    fun errorDecoder(): FeignExceptionDecoder? = FeignExceptionDecoder()

}