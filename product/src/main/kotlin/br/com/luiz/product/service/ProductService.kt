package br.com.luiz.product.service

import br.com.luiz.product.dto.*
import br.com.luiz.product.exception.NotFoundException
import br.com.luiz.product.mapper.ProductFormMapper
import br.com.luiz.product.mapper.ProductUpdateViewMapper
import br.com.luiz.product.mapper.ProductViewMapper
import br.com.luiz.product.model.Product
import br.com.luiz.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val productFormMapper: ProductFormMapper,
    private val productViewMapper: ProductViewMapper,
    private val productUpdateViewMapper: ProductUpdateViewMapper,
    private val notFoundMessage: String = "Product not found."
) {

    fun findAll(): List<ProductView> {
        return productRepository.findAll()
            .map { p ->
                productViewMapper.map(p)
            }
    }

    fun save(form: NewProductForm): ProductView {
        val product = productFormMapper.map(form)
        productRepository.save(product)
        return productViewMapper.map(product)
    }

    fun update(id: Long, form: UpdateProductForm): ProductUpdateView {
        val product = productRepository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        product.name = form.name
        product.quantity = form.quantity
        product.description = form.description
        product.price = form.price
        val saveProduct = productRepository.save(product)
        return productUpdateViewMapper.map(saveProduct)
    }

    fun findById(id: Long): ProductView {
        val product = productRepository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return productViewMapper.map(product)
    }

    fun deactivate(id: Long): ProductView {
        val product: Product = productRepository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        product.isActive = false
        val saveProduct = productRepository.save(product)
        return productViewMapper.map(saveProduct)
    }

    fun activate(id: Long): ProductView {
        val product: Product = productRepository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        product.isActive = true
        val saveProduct = productRepository.save(product)
        return productViewMapper.map(saveProduct)
    }

    fun deleteById(id: Long) {
        productRepository.deleteById(id)
    }

}