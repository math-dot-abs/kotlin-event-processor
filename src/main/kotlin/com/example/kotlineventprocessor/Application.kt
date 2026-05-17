package com.example.kotlineventprocessor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinEventProcessorApplication

fun main(args: Array<String>) {
    runApplication<KotlinEventProcessorApplication>(*args)
}