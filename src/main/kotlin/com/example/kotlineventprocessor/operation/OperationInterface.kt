package com.example.kotlineventprocessor.operation

import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.producer.SapRequest

interface OperationInterface {
    fun isSupported(contract: Contract): Boolean
    fun execute(contexts: List<AccountingContext>): List<SapRequest>
}