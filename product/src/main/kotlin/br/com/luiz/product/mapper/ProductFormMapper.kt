package br.com.luiz.product.mapper

import br.com.luiz.product.dto.NewProductForm
import br.com.luiz.product.model.Product
import org.springframework.stereotype.Component

@Component
class ProductFormMapper : Mapper<NewProductForm, Product> {

    override fun map(t: NewProductForm): Product {
        return Product(
            name = t.name,
            quantity = t.quantity,
            price = t.price,
            description = t.description
        )
    }

}