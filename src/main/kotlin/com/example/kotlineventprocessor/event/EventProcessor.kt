package com.example.kotlineventprocessor.event

import com.example.kotlineventprocessor.action.ActionBase
import com.example.kotlineventprocessor.action.ActionRegistry
import com.example.kotlineventprocessor.producer.Producer
import com.example.kotlineventprocessor.producer.SapRequest
import org.springframework.stereotype.Service

@Service
class EventProcessor(val actionRegistry: ActionRegistry, val producer: Producer) {

    fun process(contract: Contract) {
        val action: ActionBase = actionRegistry.get(contract.processingType)
        val result: List<SapRequest> = action.perform(contract);
        producer.produce(result)
    }
}