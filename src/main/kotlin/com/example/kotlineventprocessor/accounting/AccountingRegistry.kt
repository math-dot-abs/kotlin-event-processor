package com.example.kotlineventprocessor.accounting

import org.springframework.stereotype.Component

@Component
class AccountingRegistry(val repository: AccountingConfigRepository) {
    fun get(processingType: Int): List<AccountingConfig> {
        return repository.findAccountingConfigsByProcessingType(processingType)
    }
}