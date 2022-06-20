package br.com.luiz.product.mapper

import br.com.luiz.product.dto.ProductUpdateView
import br.com.luiz.product.model.Product
import org.springframework.stereotype.Component

@Component
class ProductUpdateViewMapper : Mapper<Product, ProductUpdateView> {

    override fun map(t: Product): ProductUpdateView {
        return ProductUpdateView(
            id = t.id,
            name = t.name,
            description = t.description,
            quantity = t.quantity,
            price = t.price
        )
    }

}
