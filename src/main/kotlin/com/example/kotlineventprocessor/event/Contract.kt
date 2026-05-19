package com.example.kotlineventprocessor.event

import java.time.LocalDateTime

data class Contract(
    val contractId: String,
    val processingType: Int,
    val taxReclamation: Double,
    val subsidyReclamation: Double,
    val ratingGender: Int,
    val partnerIdPolicyHolder: String,
    val effectiveFrom: LocalDateTime,
    val processingDate: LocalDateTime,
    var pickupDate: LocalDateTime?,
    var cancellationDate : LocalDateTime?,
    var acknowledgmentDate : LocalDateTime?,
    val productVariantType: Int,
    val priceTier: Int,
    val contractParts: List<ContractPart>,
)

data class ContractPart(
    val surplusApplicationType: Int,
    val legacyIndicator: Boolean,
    val statementGeneration: Int,
    val externalFundId: Int,
    val rateVariantId: Int,
    val beneficiary: List<Beneficiary>,
)

data class Beneficiary(
    val reserveFund: Double,
    val valuationReserve: Double,
    val surplusShare: Double,
    val finalSurplusShare: Double,
    val bankRoutingNumber: Int,
    val partnerId: String,
)
