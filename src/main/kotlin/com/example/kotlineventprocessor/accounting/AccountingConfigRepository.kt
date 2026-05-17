package com.example.kotlineventprocessor.accounting

import org.springframework.data.jpa.repository.JpaRepository

interface AccountingConfigRepository : JpaRepository<AccountingConfig, Int> {
    fun findAccountingConfigsByProcessingType(processingType: Int): List<AccountingConfig>
}