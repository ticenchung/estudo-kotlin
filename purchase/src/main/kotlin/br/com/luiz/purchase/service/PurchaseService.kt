package br.com.luiz.purchase.service

import br.com.luiz.purchase.dto.NewPurchaseForm
import br.com.luiz.purchase.dto.PurchaseView
import br.com.luiz.purchase.integration.feign.client.CustomerClient
import br.com.luiz.purchase.integration.feign.client.ProductClient
import br.com.luiz.purchase.mapper.PurchaseFormMapper
import br.com.luiz.purchase.mapper.PurchaseViewMapper
import br.com.luiz.purchase.repository.PurchaseRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val purchaseViewMapper: PurchaseViewMapper,
    private val purchaseFormMapper: PurchaseFormMapper,
    private val customerClient: CustomerClient,
    private val productClient: ProductClient
) {

    fun save(form: NewPurchaseForm): PurchaseView {
        val purchase = purchaseFormMapper.map(form)
        val customer = customerClient.findCustomer(purchase.idClient)
        val product = productClient.findProduct(purchase.idProduct)
        purchase.idClient = customer.id!!
        purchase.price = product.price
        purchase.total = purchase.quantity.toBigDecimal().multiply(product.price)
        purchaseRepository.save(purchase)
        return purchaseViewMapper.map(purchase)
    }

}