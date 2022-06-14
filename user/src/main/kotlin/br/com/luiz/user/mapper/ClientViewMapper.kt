package br.com.luiz.user.mapper

import br.com.luiz.user.dto.ClientView
import br.com.luiz.user.model.Client
import org.springframework.stereotype.Component

@Component
class ClientViewMapper : Mapper<Client, ClientView> {

    override fun map(t: Client): ClientView {
        return ClientView(
            id = t.id,
            name = t.name,
            telephone = t.telephone,
            email = t.email,
            isActive = t.isActive
        )
    }

}
