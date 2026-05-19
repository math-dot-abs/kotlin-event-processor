package com.example.kotlineventprocessor.action

import org.springframework.context.annotation.Configuration

@Configuration
class ActionRegistry(
    val defaultAction: DefaultAction
) {

    fun get(processingType: Int): ActionBase {
        return when (processingType) {
            321 -> defaultAction
            else -> { throw IllegalArgumentException("There exists no action for processingType $processingType") }
        }
    }
}