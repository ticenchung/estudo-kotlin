package br.com.luiz.user.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.SecurityReference
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.Arrays


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api() : Docket =  Docket(DocumentationType.SWAGGER_2)
        .apiInfo(
            ApiInfoBuilder()
                .title("User")
                .description("API User")
                .version("1.0")
                .build())
        .securityContexts(listOf(securityContext()))
        .securitySchemes(listOf(apiKey()))
        .select()
        .apis((RequestHandlerSelectors.basePackage("br.com.luiz.user.controller")))
        .paths(PathSelectors.any())
        .build()

    private fun apiKey(): ApiKey = ApiKey("JWT", "Authorization", "header")

    private fun securityContext(): SecurityContext = SecurityContext.builder().securityReferences(defaultAuth()).build()

    private fun defaultAuth(): List<SecurityReference> {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes: Array<AuthorizationScope?> = arrayOfNulls<AuthorizationScope>(1)
        authorizationScopes[0] = authorizationScope
        return listOf(SecurityReference("JWT", authorizationScopes))
    }

}