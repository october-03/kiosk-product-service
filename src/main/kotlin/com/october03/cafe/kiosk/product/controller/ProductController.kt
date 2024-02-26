package com.october03.cafe.kiosk.product.controller

import com.october03.cafe.kiosk.product.dto.CreateProductDto
import com.october03.cafe.kiosk.product.repository.Product
import com.october03.cafe.kiosk.product.service.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(private val productService: ProductService) {
  @PostMapping("/register")
  fun register(@RequestBody req: CreateProductDto): Product {
    return productService.createProduct(req)
  }
}