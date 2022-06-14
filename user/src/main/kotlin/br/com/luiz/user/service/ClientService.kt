package br.com.luiz.user.service

import br.com.luiz.user.dto.ClientView
import br.com.luiz.user.dto.NewClientForm
import br.com.luiz.user.mapper.ClientFormMapper
import br.com.luiz.user.mapper.ClientViewMapper
import br.com.luiz.user.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val clientRepository: ClientRepository,
    private val clientViewMapper: ClientViewMapper,
    private val clientFormMapper: ClientFormMapper
) {

    fun register(form: NewClientForm): ClientView {
        val client = clientFormMapper.map(form)
        clientRepository.save(client)
        return clientViewMapper.map(client)
    }

}