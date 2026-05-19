package com.example.kotlineventprocessor.operation

import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.producer.SapRequest
import com.example.kotlineventprocessor.producer.SapRequestConverter
import java.time.LocalDateTime
import java.util.*

class DefaultOperation(val converter: SapRequestConverter) : OperationInterface {
    override fun isSupported(contract: Contract): Boolean {
        return contract.pickupDate == null && contract.cancellationDate == null;
    }

    override fun execute(contexts: List<AccountingContext>): List<SapRequest> {
        return contexts.stream()
            .peek { context -> context.contract.pickupDate = LocalDateTime.now() }
            .map(converter::convert)
            .toList()
    }
}