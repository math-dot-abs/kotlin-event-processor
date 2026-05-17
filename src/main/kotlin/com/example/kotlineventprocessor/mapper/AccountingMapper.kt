package com.example.kotlineventprocessor.mapper

import com.example.kotlineventprocessor.accounting.AccountingConfig
import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.accounting.AccountingRegistry
import com.example.kotlineventprocessor.accounting.ConfigResolver
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.rule.ContextPopulator
import org.springframework.stereotype.Component

@Component
class AccountingMapper(val accountingRegistry: AccountingRegistry, val contextPopulator: ContextPopulator) : MapperInterface {
    override fun map(contract: Contract): List<AccountingContext> {
        val configs: List<AccountingConfig> = accountingRegistry.get(contract.processingType)
        val baseContext = AccountingContext(contract)
        val resolver = ConfigResolver()
        val results: List<AccountingContext> = resolver.resolve(baseContext, configs)
        results.forEach(contextPopulator::populate)
        return results
    }
}