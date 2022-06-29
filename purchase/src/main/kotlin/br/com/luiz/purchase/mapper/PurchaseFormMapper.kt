package br.com.luiz.purchase.mapper

import br.com.luiz.purchase.dto.NewPurchaseForm
import br.com.luiz.purchase.models.Purchase
import org.springframework.stereotype.Component

@Component
class PurchaseFormMapper: Mapper<NewPurchaseForm, Purchase> {

    override fun map(t: NewPurchaseForm): Purchase {
        return Purchase(
            idClient = t.idClient,
            idProduct = t.idProduct,
            quantity = t.quantity
        )
    }

}