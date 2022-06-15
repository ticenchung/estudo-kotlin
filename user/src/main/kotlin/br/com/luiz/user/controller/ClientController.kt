package br.com.luiz.user.controller

import br.com.luiz.user.dto.ClientView
import br.com.luiz.user.dto.NewClientForm
import br.com.luiz.user.model.Client
import br.com.luiz.user.service.ClientService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/clients")
class ClientController(
    private val service: ClientService
) {

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