package br.com.luiz.product.service

import br.com.luiz.product.dto.*
import br.com.luiz.product.exception.NotFoundException
import br.com.luiz.product.mapper.ProductFormMapper
import br.com.luiz.product.mapper.ProductUpdateViewMapper
import br.com.luiz.product.mapper.ProductViewMapper
import br.com.luiz.product.model.Product
import br.com.luiz.product.repository.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val productFormMapper: ProductFormMapper,
    private val productViewMapper: ProductViewMapper,
    private val productUpdateViewMapper: ProductUpdateViewMapper,
    private val notFoundMessage: String = "Product not found."
) {

    fun findAll(
        productName: String?,
        pagination: Pageable
    ): Page<ProductView> {
        val products = if (productName == null) {
            productRepository.findAll(pagination)
        } else {
            productRepository.findByName(productName, pagination)
        }
        return products.map { p ->
            productViewMapper.map(p)
        }
    }

    fun save(form: NewProductForm): ProductView {
        val product = productFormMapper.map(form)
        productRepository.save(product)
        return productViewMapper.map(product)
    }

    fun update(id: Long, form: UpdateProductForm): ProductUpdateView {
        val product = findProduct(id)
        product.name = form.name
        product.quantity = form.quantity
        product.description = form.description
        product.price = form.price
        val saveProduct = productRepository.save(product)
        return productUpdateViewMapper.map(saveProduct)
    }

    fun findById(id: Long): ProductView = productViewMapper.map(findProduct(id))

    fun deactivate(id: Long): ProductView = productViewMapper.map(switchActive(id, false))

    fun activate(id: Long): ProductView = productViewMapper.map(switchActive(id, true))

    fun deleteById(id: Long) = productRepository.deleteById(id)

    fun findProduct(id: Long): Product = productRepository.findById(id)
        .orElseThrow { NotFoundException(notFoundMessage) }

    fun switchActive(id: Long, active: Boolean): Product {
        val product = findProduct(id)
        product.isActive = active
        return productRepository.save(product)
    }

}