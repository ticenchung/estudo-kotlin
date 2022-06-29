package br.com.luiz.purchase.mapper

import br.com.luiz.purchase.dto.PurchaseView
import br.com.luiz.purchase.models.Purchase
import org.springframework.stereotype.Component

@Component
class PurchaseViewMapper : Mapper<Purchase, PurchaseView> {

    override fun map(t: Purchase): PurchaseView {
        return PurchaseView(
            id = t.id,
            idClient = t.idClient,
            idProduct = t.idProduct,
            quantity = t.quantity,
            price = t.price,
            total = t.total
        )
    }

}