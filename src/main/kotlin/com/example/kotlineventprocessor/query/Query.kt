package com.example.kotlineventprocessor.query

import java.math.BigDecimal

class Query(
    val tableName: QueryableEntity,
    val fieldName: FieldName?,
    val operation: Operation?,
    val value: Value?
)

@JvmInline
value class FieldName (private val s : String?)

enum class Operation (val s : String){
    GREATER_THAN(">"),
    EQUALS("=="),
    IN("IN"),
    NOTIN("NOTIN");

    companion object {
        fun fromString(value: String?): Operation? =
            entries.find { it.s == value }
    }
}

@JvmInline
value class Value (private val s : String?){
    fun convertToBigDecimal(): BigDecimal =
        BigDecimal.valueOf(s.orEmpty().toDouble())

    fun convertToBigDecimalList(): List<BigDecimal> =
        s.orEmpty()
            .replace("(", "")
            .replace(")", "")
            .split(",")
            .map { BigDecimal(it) }
}