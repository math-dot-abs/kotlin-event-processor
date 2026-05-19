package de.inter.lv.exkasso.event.processor.utility

import de.inter.lv.exkasso.event.processor.entity.excelQuery.Query
import de.inter.lv.exkasso.event.processor.entity.excelQuery.QueryableEntities
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
            QueryableEntities.valueOf(tableAndField[0]),
            tableAndField.getOrNull(1),
            tokens.getOrNull(1),
            tokens.getOrNull(2)
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
            ">" -> result > convertToBigDecimal(value)
            "==" -> result.compareTo(convertToBigDecimal(value)) == 0
            "IN" -> convertToBigDecimalList(value).contains(result)
            "NOTIN" -> !convertToBigDecimalList(value).contains(result)
            else -> throw IllegalArgumentException("Unsupported Operation: $operation")
        }
    }

    private fun convertToBigDecimal(value: String): BigDecimal =
        BigDecimal.valueOf(value.toDouble())

    private fun convertToBigDecimalList(value: String): List<BigDecimal> =
        value.replace("(", "")
            .replace(")", "")
            .split(",")
            .map { BigDecimal(it) }
}