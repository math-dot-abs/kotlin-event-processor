package com.example.kotlineventprocessor.event


import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class Consumer(val processor: EventProcessor) {

    @JmsListener(destination = "virtualTopic")
    fun consumeEvent(contract: Contract) {
        processor.process(contract)
    }
}