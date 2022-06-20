package br.com.luiz.product.controller

import br.com.luiz.product.dto.NewProductForm
import br.com.luiz.product.dto.ProductUpdateView
import br.com.luiz.product.dto.ProductView
import br.com.luiz.product.dto.UpdateProductForm
import br.com.luiz.product.service.ProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/products")
class ProductController(
    private val service: ProductService
) {

    @GetMapping
    fun list(
        @RequestParam(required = false) productName: String?,
        @PageableDefault(size = 5, direction = Sort.Direction.ASC) pagination: Pageable
    ): Page<ProductView> = service.findAll(productName, pagination)

    @GetMapping("/{id}")
    fun findProductById(@PathVariable id: Long): ResponseEntity<ProductView> {
        val productView = service.findById(id)
        return ResponseEntity.ok().body(productView)
    }

    @PostMapping
    fun save(
        @RequestBody @Valid form: NewProductForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ProductView> {
        val productView = service.save(form)
        val uri = uriBuilder.path("/products/${productView.id}").build().toUri()
        return ResponseEntity.created(uri).body(productView)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,
               @RequestBody @Valid form: UpdateProductForm
    ): ResponseEntity<ProductUpdateView> {
        val productView = service.update(id, form)
        return ResponseEntity.ok().body(productView)
    }

    @PatchMapping("/{id}/deactivate")
    fun deactivate(@PathVariable id: Long): ResponseEntity<ProductView> {
        val productView = service.deactivate(id)
        return ResponseEntity.ok().body(productView)
    }

    @PatchMapping("/{id}/activate")
    fun activate(@PathVariable id: Long): ResponseEntity<ProductView> {
        val productView = service.activate(id)
        return ResponseEntity.ok().body(productView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = service.deleteById(id)

}