package br.com.luiz.user.service

import br.com.luiz.user.dto.ClientView
import br.com.luiz.user.dto.NewClientForm
import br.com.luiz.user.exception.NotFoundException
import br.com.luiz.user.integration.feign.client.AddressFormClient
import br.com.luiz.user.integration.feign.client.ZipCodeClient
import br.com.luiz.user.mapper.ClientFormMapper
import br.com.luiz.user.mapper.ClientViewMapper
import br.com.luiz.user.model.Address
import br.com.luiz.user.model.Client
import br.com.luiz.user.repository.ClientRepository
import com.google.gson.JsonObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val clientRepository: ClientRepository,
    private val clientViewMapper: ClientViewMapper,
    private val clientFormMapper: ClientFormMapper,
    private val zipCodeClient: ZipCodeClient,
    private val notFoundMessage: String = "Client not found."
) {

    fun findAll(
        clientName: String?,
        pagination: Pageable
    ): Page<ClientView> {
        val clients = if (clientName == null) {
            clientRepository.findAll(pagination)
        } else {
            clientRepository.findByName(clientName, pagination)
        }
        return clients.map { c ->
            clientViewMapper.map(c)
        }
    }

    fun register(form: NewClientForm): ClientView {
        val client = clientFormMapper.map(form)
        val zipCode = zipCodeClient.generateZipCode(
            AddressFormClient(
                client.address.street,
                client.address.city,
                client.address.state
            )
        )
        var format = zipCode.replace("{\"zipCode\":\"", "").replace("\"}", "")
        client.address.zipCode = format
        clientRepository.save(client)
        return clientViewMapper.map(client)
    }

    fun findById(id: Long): ClientView = clientViewMapper.map(findClient(id))

    fun deactivate(id: Long): ClientView = clientViewMapper.map(switchActive(id, false))

    fun activate(id: Long): ClientView = clientViewMapper.map(switchActive(id, true))

    fun findClient(id: Long): Client = clientRepository.findById(id)
        .orElseThrow { NotFoundException(notFoundMessage) }

    fun switchActive(id: Long, active: Boolean): Client {
        val client = findClient(id)
        client.isActive = active
        return clientRepository.save(client)
    }

}