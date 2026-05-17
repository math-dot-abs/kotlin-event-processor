package com.example.kotlineventprocessor.rule

import com.example.kotlineventprocessor.accounting.AccountingContext

interface RuleInterface {
    fun apply(context: AccountingContext)
}