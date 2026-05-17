package com.example.kotlineventprocessor.action

import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.mapper.MapperInterface
import com.example.kotlineventprocessor.mapper.MapperRegistry
import com.example.kotlineventprocessor.operation.OperationInterface
import com.example.kotlineventprocessor.producer.SapRequest

abstract class ActionBase(val mapperRegistry: MapperRegistry, val operations: List<OperationInterface>) {

    abstract fun performAdditionally()

    fun perform(contract: Contract): List<SapRequest> {
        val mapper: MapperInterface = mapperRegistry.get(contract.processingType)
        val contexts: List<AccountingContext> = mapper.map(contract)

        return findSupportedOperation(contract).execute(contexts)
    }

    fun findSupportedOperation(contract: Contract): OperationInterface {
        return operations.stream()
            .filter { it.isSupported(contract) }
            .findFirst()
            .orElseThrow {
                IllegalArgumentException("No Supported Operation found (ContractId: {%s})"
                    .format(contract.contractId))
            }

    }
}