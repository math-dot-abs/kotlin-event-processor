package com.example.kotlineventprocessor.rule

import com.example.kotlineventprocessor.accounting.AccountingContext
import org.springframework.stereotype.Component

@Component
class ContextPopulator(val rules: List<RuleInterface>) {
    fun populate(context: AccountingContext) {
        rules.stream().map { it.apply(context) }
    }
}