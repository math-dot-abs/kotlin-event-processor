package com.example.kotlineventprocessor.accounting

import com.example.kotlineventprocessor.event.Beneficiary
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.event.ContractPart
import java.time.LocalDateTime

data class AccountingContext(
    var accountingConfig : AccountingConfig,
    val contract: Contract,
    var beneficiary: Beneficiary? = null,
    var contractPart: ContractPart? = null,
    val insuranceType: String = "",
    val insuranceTypeLong: String? = null,
    val stockType: String? = null,
    val claimType: String? = null,
    val totalAmount : Double,
    val businessPartner : String,
    val businessPartnerNumber : String,
    val validAsOf : LocalDateTime,
    val validUntil : LocalDateTime,
    val bankRoutingNumber : String,
    val companyNumber : String
)