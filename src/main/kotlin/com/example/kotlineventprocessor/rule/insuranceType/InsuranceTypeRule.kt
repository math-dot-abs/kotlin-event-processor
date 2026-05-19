package com.example.kotlineventprocessor.rule.insuranceType

import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.event.ContractPart
import com.example.kotlineventprocessor.rule.RuleInterface
import org.springframework.stereotype.Component

@Component
class InsuranceTypeRule(val repository: InsuranceTypeConfigurationRepository) : RuleInterface {

    override fun apply(context: AccountingContext) {
        if (context.accountingConfig!!.insuranceType == null) return
        // Compute Versicherungsart only if ExcelConfiguration column contains "Versicherungsart", otherwise use the given String
        if (!context.accountingConfig!!.insuranceType.equals("Versicherungsart")) {
            context.insuranceType = context.accountingConfig!!.insuranceType
            return
        }

        val rules: List<InsuranceTypeConfiguration> = repository.findAll()

        val contract: Contract = context.contract
        val contractPart: ContractPart = context.contractPart!!
        for (rule in rules) {
            if (rule.productVariantType.contains(contract.productVariantType)
                && rule.priceTier.contains(contract.priceTier)
                && rule.rateVariantId.contains(contractPart.rateVariantId)
            ) {
                context.insuranceType = rule.type
            }
        }
    }
}