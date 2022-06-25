package br.com.luiz.user.controller

import br.com.luiz.user.dto.ClientView
import br.com.luiz.user.dto.NewClientForm
import br.com.luiz.user.model.Client
import br.com.luiz.user.service.ClientService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/clients")
class ClientController(
    private val service: ClientService
) {

    @GetMapping
    fun list(
        @RequestParam(required = false) clientName: String?,
        @PageableDefault(size = 5, direction = Sort.Direction.ASC) pagination: Pageable
    ): Page<ClientView> = service.findAll(clientName, pagination)

    @GetMapping("/{id}")
    fun findClientById(@PathVariable id: Long): ResponseEntity<ClientView> {
        val productView = service.findById(id)
        return ResponseEntity.ok().body(productView)
    }

    @PostMapping
    fun register(
        @RequestBody @Valid form: NewClientForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ClientView> {
        val clientView = service.register(form)
        val uri = uriBuilder.path("/clients/${clientView.id}").build().toUri()
        return ResponseEntity.created(uri).body(clientView)
    }

    @PatchMapping("/{id}/deactivate")
    fun deactivate(@PathVariable id: Long): ResponseEntity<ClientView> {
        val clientView = service.deactivate(id)
        return ResponseEntity.ok().body(clientView)
    }

    @PatchMapping("/{id}/activate")
    fun activate(@PathVariable id: Long): ResponseEntity<ClientView> {
        val clientView = service.activate(id)
        return ResponseEntity.ok().body(clientView)
    }

}