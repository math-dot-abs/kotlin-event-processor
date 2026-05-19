package com.example.kotlineventprocessor.accounting

import com.example.kotlineventprocessor.event.Beneficiary
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.event.ContractPart
import com.example.kotlineventprocessor.query.QueryableEntity
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountingContext(
    var accountingConfig : AccountingConfig? = null,
    val contract: Contract,
    var beneficiary: Beneficiary? = null,
    var contractPart: ContractPart? = null,
    var insuranceType: String? = null,
    var insuranceTypeLong: String? = null,
    var stockType: String? = null,
    var claimType: String? = null,
    var totalAmount : BigDecimal = BigDecimal.ZERO,
    var businessPartner : String = "",
    var businessPartnerNumber : String = "",
    val validAsOf : LocalDateTime = LocalDateTime.MAX,
    val validUntil : LocalDateTime = LocalDateTime.MAX,
    var bankRoutingNumber : String = "",
    val companyNumber : String = ""
) {
    fun getEntityByName(entityName: QueryableEntity): Any? {
        return when (entityName) {
            QueryableEntity.CONTRACT -> contract
            QueryableEntity.CONTRACTPART -> contractPart
            QueryableEntity.BENEFICIARY -> beneficiary
        }
    }
}