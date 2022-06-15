package br.com.luiz.user.service

import br.com.luiz.user.dto.ClientView
import br.com.luiz.user.dto.NewClientForm
import br.com.luiz.user.exception.NotFoundException
import br.com.luiz.user.mapper.ClientFormMapper
import br.com.luiz.user.mapper.ClientViewMapper
import br.com.luiz.user.model.Client
import br.com.luiz.user.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val clientRepository: ClientRepository,
    private val clientViewMapper: ClientViewMapper,
    private val clientFormMapper: ClientFormMapper,
    private val notFoundMessage: String = "Client not found."
) {

    fun register(form: NewClientForm): ClientView {
        val client = clientFormMapper.map(form)
        clientRepository.save(client)
        return clientViewMapper.map(client)
    }

    fun deactivate(id: Long): ClientView {
        val cli: Client = clientRepository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        cli.isActive = false
        val saveCli = clientRepository.save(cli)
        return clientViewMapper.map(saveCli)
    }

    fun activate(id: Long): ClientView {
        val cli: Client = clientRepository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        cli.isActive = true
        val saveCli = clientRepository.save(cli)
        return clientViewMapper.map(saveCli)
    }

}