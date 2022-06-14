package br.com.luiz.user.mapper

import br.com.luiz.user.dto.NewClientForm
import br.com.luiz.user.model.Client
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class ClientFormMapper : Mapper<NewClientForm, Client> {

    override fun map(t: NewClientForm): Client {
        val encoder: BCryptPasswordEncoder = BCryptPasswordEncoder()
        return Client(
            name = t.name,
            age = t.age,
            address = t.address,
            telephone = t.telephone,
            email = t.email,
            password = encoder.encode(t.password)
        )
    }

}