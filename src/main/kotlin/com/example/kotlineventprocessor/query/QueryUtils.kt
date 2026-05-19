package de.inter.lv.exkasso.event.processor.utility

import com.example.kotlineventprocessor.query.FieldName
import com.example.kotlineventprocessor.query.Operation
import com.example.kotlineventprocessor.query.Query
import com.example.kotlineventprocessor.query.QueryableEntity
import com.example.kotlineventprocessor.query.TableName
import com.example.kotlineventprocessor.query.Value
import java.math.BigDecimal

object QueryUtils {

    /**
     * Konvertiert einen String, der mehrere verkettete queries enthalten könnte, in eine Liste von Query Objekten
     */
    fun getQueries(feldInput: String): List<Query> =
        feldInput.split("&&").map { convertStringToQuery(it) }

    /**
     * Konvertiert einen String einer einzelnen query in ein Query Objekt
     */
    private fun convertStringToQuery(stringQuery: String): Query {
        val tokens = stringQuery.trim().split(" ", limit = 3)
        val tableAndField = convertStringToTableAndField(tokens[0])
        return Query(
            TableName(QueryableEntity.valueOf(tableAndField[0])),
            FieldName(tableAndField.getOrNull(1)),
            Operation.fromString(tokens.getOrNull(1)),
            Value(tokens.getOrNull(2))
        )
    }

    fun convertStringToTableAndField(stringTableAndField: String): List<String> =
        stringTableAndField.split(".", limit = 2)

    /**
     * @param result Wert des Felds definiert in query.fieldName
     * @param query  Query, die ausgeführt werden soll
     *
     * Vergleicht result und den gegebenen Wert aus der Query (query.value) mit der Operation query.operator
     * query.value kann ebenfalls eine Liste von Werten sein
     */
    fun performCheckOnEntity(result: BigDecimal, query: Query): Boolean {
        val operation = query.operation ?: throw IllegalArgumentException("Operation darf nicht null sein")
        val value = query.value ?: throw IllegalArgumentException("Value darf nicht null sein")

        return when (operation) {
            Operation.GREATER_THAN  -> result > value.convertToBigDecimal()
            Operation.EQUALS -> result.compareTo(value.convertToBigDecimal()) == 0
            Operation.IN -> value.convertToBigDecimalList().contains(result)
            Operation.NOTIN -> value.convertToBigDecimalList().contains(result)
        }
    }
}