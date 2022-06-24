package br.com.luiz.user.service

import br.com.luiz.user.exception.AuthenticationException
import br.com.luiz.user.repository.ClientRepository
import br.com.luiz.user.security.UserCustomDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsCustomService(
    private val clientRepository: ClientRepository
) : UserDetailsService {

    override fun loadUserByUsername(id: String): UserDetails {
        val client = clientRepository.findById(id.toLong()).orElseThrow { AuthenticationException("Client not found.", "999") }
        return UserCustomDetails(client)
    }

}