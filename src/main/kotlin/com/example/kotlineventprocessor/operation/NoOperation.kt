package com.example.kotlineventprocessor.operation

import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.producer.SapRequest
import java.time.LocalDateTime

class NoOperation(converter: SapRequestConverter) : OperationInterface{
    override fun isSupported(contract: Contract): Boolean {
        return contract.pickupDate == null && contract.cancellationDate != null
    }

    override fun execute(contexts: List<AccountingContext>): List<SapRequest> {
        contexts.get(0).contract.pickupDate = LocalDateTime.now()
        contexts.get(0).contract.acknowledgmentDate = LocalDateTime.now()
        return emptyList();
    }
}