package br.com.luiz.product.mapper

import br.com.luiz.product.dto.ProductView
import br.com.luiz.product.model.Product
import org.springframework.stereotype.Component

@Component
class ProductViewMapper : Mapper<Product, ProductView> {

    override fun map(t: Product): ProductView {
        return ProductView(
            id = t.id,
            name = t.name,
            description = t.description,
            price = t.price,
            isActive = t.isActive
        )
    }

}