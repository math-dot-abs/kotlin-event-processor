package com.example.kotlineventprocessor.mapper

import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.event.Contract

interface MapperInterface {
    fun map(contract: Contract): List<AccountingContext>
}