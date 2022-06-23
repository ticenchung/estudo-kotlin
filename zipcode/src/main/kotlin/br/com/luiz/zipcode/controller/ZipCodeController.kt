package br.com.luiz.zipcode.controller

import br.com.luiz.zipcode.dto.AddressForm
import br.com.luiz.zipcode.dto.ZipCodeView
import br.com.luiz.zipcode.service.ZipCodeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/zipcode")
class ZipCodeController(
    private val zipCodeService: ZipCodeService
) {

    @PostMapping
    fun generateZipCode(@RequestBody @Valid form: AddressForm): ResponseEntity<ZipCodeView> {
        val zipCodeView = zipCodeService.generate()
        return ResponseEntity.ok().body(zipCodeView)
    }
}