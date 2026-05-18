package com.example.kotlineventprocessor.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType

@EnableJms
@Configuration
class JmsConfig {

    @Bean
    fun messageConverter(): MessageConverter = MappingJackson2MessageConverter().apply {
        setTargetType(MessageType.TEXT)
        setTypeIdPropertyName("_type")
        setObjectMapper(objectMapper())
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return JsonMapper.builder()
            .addModule(JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).build()
    }
}