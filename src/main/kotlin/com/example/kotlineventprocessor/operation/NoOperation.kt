package com.example.kotlineventprocessor.operation

import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.producer.SapRequest
import com.example.kotlineventprocessor.producer.SapRequestConverter
import java.time.LocalDateTime

class NoOperation(val converter: SapRequestConverter) : OperationInterface{
    override fun isSupported(contract: Contract): Boolean {
        return contract.pickupDate == null && contract.cancellationDate != null
    }

    override fun execute(contexts: List<AccountingContext>): List<SapRequest> {
        contexts.get(0).contract.pickupDate = LocalDateTime.now()
        contexts.get(0).contract.acknowledgmentDate = LocalDateTime.now()
        return emptyList();
    }
}