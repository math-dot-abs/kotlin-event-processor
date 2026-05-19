package com.example.kotlineventprocessor.rule.insuranceType

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class InsuranceTypeConfiguration (
    @Id var type: String = "",
    val productVariantType: List<Int> = listOf(),
    val rateVariantId: List<Int> = listOf(),
    val priceTier: List<Int> = listOf()
)