package com.example.kotlineventprocessor.rule

import com.example.kotlineventprocessor.accounting.AccountId
import com.example.kotlineventprocessor.accounting.AccountingConfig
import com.example.kotlineventprocessor.accounting.AccountingContext
import org.springframework.stereotype.Component

@Component
class AccountIdRule : RuleInterface {

    override fun apply(context: AccountingContext) {
        val accountingConfig: AccountingConfig = context.accountingConfig!!
        val accountId: AccountId = accountingConfig.accountId!!
        when (accountId) {
            AccountId.STATE -> context.businessPartnerNumber = PARTNER_ID_STATE
            AccountId.CUSTOMER -> context.businessPartnerNumber = context.beneficiary!!.bankRoutingNumber.toString()
            else -> error("Unknown accountId: $accountId")
        }
        context.businessPartner = context.contract.partnerIdPolicyHolder
    }

    companion object {
        const val PARTNER_ID_STATE = "2986269"
    }
}