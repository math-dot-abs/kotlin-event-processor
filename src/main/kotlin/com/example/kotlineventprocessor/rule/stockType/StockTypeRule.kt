package de.inter.lv.exkasso.event.processor.rules;

import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.event.ContractPart
import com.example.kotlineventprocessor.rule.RuleInterface
import com.example.kotlineventprocessor.rule.stockType.StockTypeConfiguration
import com.example.kotlineventprocessor.rule.stockType.StockTypeConfigurationRepository
import org.springframework.stereotype.Component

@Component
class StockTypeRule (val repository: StockTypeConfigurationRepository): RuleInterface {

    override fun apply(context: AccountingContext) {
        if (context.accountingConfig!!.stockType == null) return

        // Compute stockType only if AccountingConfiguration column contains "StockType", otherwise use the given String
        if (!context.accountingConfig!!.stockType.equals("StockType")) {
            context.stockType = context.accountingConfig!!.stockType
            return
        }

        val stockTypes : List<StockTypeConfiguration> = repository.findAll()

        val contractPart: ContractPart = context.contractPart!!
        val contract: Contract = context.contract
        for (stockType in stockTypes) {
          if (stockType.legacyIndicator == contractPart.legacyIndicator
              && stockType.getInStatementGeneration() == stockType.statementGeneration.contains(contractPart.statementGeneration)
              && stockType.getInRatingGender() == stockType.ratingGender.equals(contract.ratingGender)
            ) {
                context.stockType = stockType.type
            }

        }
    }
}

