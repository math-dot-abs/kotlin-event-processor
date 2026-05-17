package com.example.kotlineventprocessor.action

import org.springframework.context.annotation.Configuration

@Configuration
class ActionRegistry {

    fun get(processingType: Int): ActionBase {
        throw NotImplementedError()
    }
}