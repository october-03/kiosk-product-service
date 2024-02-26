package com.october03.cafe.kiosk.product.service

import com.october03.cafe.kiosk.product.dto.CreateProductDto
import com.october03.cafe.kiosk.product.dto.ProductCategory
import com.october03.cafe.kiosk.product.repository.Product
import com.october03.cafe.kiosk.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {
  fun createProduct(req: CreateProductDto): Product {
    val newProduct = Product(
      name = req.name,
      price = req.price,
      image = req.image,
      category = req.category
    )

    productRepository.save(newProduct)

    return newProduct
  }

  fun getProductById(id: Long): Product? {
    return productRepository.findById(id).orElse(null)
  }

  fun getProductsByCategory(category: ProductCategory): List<Product>? {
    return productRepository.findByCategory(category)
  }

  fun getAllProducts(): List<Product>? {
    return productRepository.findAll()
  }
}