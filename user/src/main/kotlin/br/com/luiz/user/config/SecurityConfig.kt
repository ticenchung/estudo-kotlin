package br.com.luiz.user.config

import br.com.luiz.user.repository.ClientRepository
import br.com.luiz.user.security.AuthenticationFilter
import br.com.luiz.user.security.AuthorizationFilter
import br.com.luiz.user.security.JwtUtil
import br.com.luiz.user.service.UserDetailsCustomService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val clientRepository: ClientRepository,
    private val jwtUtil: JwtUtil,
    private val authenticationConfiguration: AuthenticationConfiguration,
    private val userDetailsCustomService: UserDetailsCustomService
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.cors().and().csrf().disable()
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.addFilter(AuthenticationFilter(authenticationConfiguration.authenticationManager, clientRepository, jwtUtil))
        http.addFilter(AuthorizationFilter(authenticationConfiguration.authenticationManager, jwtUtil))
        http.headers().frameOptions().disable()
        http.authorizeRequests()
            .antMatchers("/h2-console/**",
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/swagger-ui/*",
                "/webjars/**",
                "/v2/**").permitAll()
            .anyRequest().authenticated()
        return http.build()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder()

}