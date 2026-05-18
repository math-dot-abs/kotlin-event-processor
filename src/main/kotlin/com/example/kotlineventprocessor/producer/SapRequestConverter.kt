package com.example.kotlineventprocessor.producer

import com.example.kotlineventprocessor.accounting.AccountingContext
import java.time.LocalDateTime

class SapRequestConverter {
    fun convert(accountingContext : AccountingContext) : SapRequest {
        return SapRequest(
            businessPartnerNumber = accountingContext.businessPartnerNumber,
            contractId = accountingContext.contract.contractId,
            amount = accountingContext.totalAmount,
            mProcess = accountingContext.accountingConfig.mprocess,
            sProcess = accountingContext.accountingConfig.sprocess,
            bankRoutingNumber = accountingContext.bankRoutingNumber,
            insuranceType = accountingContext.insuranceType,
            claimType = accountingContext.claimType,
            riskType = accountingContext.accountingConfig.riskType,
            validAsOf = accountingContext.validAsOf,
            validUntil = accountingContext.validUntil,
            productGroup = accountingContext.accountingConfig.productGroup,
            insuranceObject = accountingContext.contract.contractId,
            businessPartner = accountingContext.businessPartner
        )
    }
}