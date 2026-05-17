package com.example.kotlineventprocessor.mapper

import org.springframework.context.annotation.Configuration

@Configuration
class MapperRegistry {
    fun get(processingType: Int): MapperInterface {
        throw NotImplementedError()
    }
}