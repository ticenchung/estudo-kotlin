package br.com.luiz.purchase.controller

import br.com.luiz.purchase.dto.NewPurchaseForm
import br.com.luiz.purchase.dto.PurchaseView
import br.com.luiz.purchase.service.PurchaseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/purchases")
class PurchaseController(
    private val service: PurchaseService
) {

    @PostMapping
    fun savePurchase(
        @RequestBody form: NewPurchaseForm,
        uriBuilder: UriComponentsBuilder
    ) : ResponseEntity<PurchaseView> {
        val purchaseView = service.save(form)
        val uri = uriBuilder.path("/purchases/${purchaseView.id}").build().toUri()
        return ResponseEntity.created(uri).body(purchaseView)
    }

}