package com.october03.cafe.kiosk.product.repository

import com.october03.cafe.kiosk.product.dto.ProductCategory
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "products")
data class Product (
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id:Long? = null,
  val name:String,
  val image: String? = null,
  val price: Long,
  @Enumerated(EnumType.STRING)
  val category: ProductCategory,
  val created_at: LocalDateTime = LocalDateTime.now()
){
  constructor() : this(
    null,
    "",
    "",
    0,
    ProductCategory.NONE
  )
}

interface ProductRepository: JpaRepository<Product, Long> {
  override fun findById(id: Long): Optional<Product>

  fun findByCategory(category: ProductCategory): List<Product>?
}