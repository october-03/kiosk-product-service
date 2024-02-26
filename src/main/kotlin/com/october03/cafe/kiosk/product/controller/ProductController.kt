package com.october03.cafe.kiosk.product.controller

import com.october03.cafe.kiosk.product.dto.CreateProductDto
import com.october03.cafe.kiosk.product.dto.ProductCategory
import com.october03.cafe.kiosk.product.repository.Product
import com.october03.cafe.kiosk.product.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val productService: ProductService) {
  @PostMapping("/register")
  fun register(@RequestBody req: CreateProductDto): Product {
    return productService.createProduct(req)
  }

  @GetMapping("/{id}")
  fun getProductById(@PathVariable id: Long): Product? {
    return productService.getProductById(id)
  }

  @GetMapping("/category/{category}")
  fun getProductByCategory(@PathVariable category: ProductCategory): List<Product>? {
    return productService.getProductsByCategory(category)
  }

  @GetMapping("/all")
  fun getAllProducts(): List<Product>? {
    return productService.getAllProducts()
  }
}