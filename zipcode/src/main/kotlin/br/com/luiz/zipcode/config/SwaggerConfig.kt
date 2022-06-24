package br.com.luiz.zipcode.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api() : Docket =  Docket(DocumentationType.SWAGGER_2)
        .apiInfo(
            ApiInfoBuilder()
                .title("Zip Code")
                .description("API Zip Code")
                .version("1.0")
                .build())
        .select()
        .apis((RequestHandlerSelectors.basePackage("br.com.luiz.zipcode.controller")))
        .paths(PathSelectors.any())
        .build()

}