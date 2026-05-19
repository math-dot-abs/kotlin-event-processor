package com.example.kotlineventprocessor.rule

import com.example.kotlineventprocessor.accounting.AccountingContext
import org.springframework.stereotype.Component

@Component
class BankRoutingNumberRule : RuleInterface {
    override fun apply(context: AccountingContext) {
        val bankRoutingNumber: Int = context.beneficiary?.bankRoutingNumber!!
        context.bankRoutingNumber = String.format("%04d", bankRoutingNumber)
    }
}