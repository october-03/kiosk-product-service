package com.october03.cafe.kiosk.product.dto

data class CreateProductDto(
  val name: String,
  val image: String?,
  val price: Long,
  val category: ProductCategory,
)
