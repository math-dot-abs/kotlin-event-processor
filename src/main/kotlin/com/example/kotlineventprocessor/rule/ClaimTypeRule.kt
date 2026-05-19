package com.example.kotlineventprocessor.rule

import com.example.kotlineventprocessor.accounting.AccountingContext
import org.springframework.stereotype.Component

@Component
class ClaimTypeRule : RuleInterface {

    override fun apply(context: AccountingContext) {
        if (context.accountingConfig!!.claimType == null) return
        // Compute claimType only if AccountingConfig column contains "claimType", otherwise use the given String
        if (context.accountingConfig!!.claimType != CLAIM_TYPE) {
            context.claimType = context.accountingConfig!!.claimType
            return
        }

        val effectiveYear: Int = context.contract.effectiveFrom.year
        val processingYear: Int = context.contract.processingDate!!.year

        context.claimType = when {
            effectiveYear == processingYear -> ClaimType.GJ.name
            effectiveYear < processingYear -> ClaimType.VU.name
            else -> error("Unexpected year combination: acknowledgment=$effectiveYear, processing=$processingYear")
        }
    }

    private enum class ClaimType {
        GJ, VU
    }

    companion object {
        const val CLAIM_TYPE = "claimType"
    }
}