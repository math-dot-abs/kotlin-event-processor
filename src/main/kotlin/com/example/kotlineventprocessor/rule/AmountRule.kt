package com.example.kotlineventprocessor.rule

import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.query.EntityReader.read
import com.example.kotlineventprocessor.query.Query
import com.example.kotlineventprocessor.query.QueryUtils
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class AmountRule : RuleInterface {
    override fun apply(context: AccountingContext) {
        val query: String = context.accountingConfig!!.query
        val subQueries: List<Query> = QueryUtils.getQueries(query)
        if (subQueries.isEmpty()) return
        setAmount(subQueries.last(), context)
    }

    private fun setAmount(query: Query, context: AccountingContext) {

        val entity = context.getEntityByName(query.tableName)!!
        val result = read(query, entity)
        context.totalAmount = when (context.accountingConfig!!.sign) {
            "40" -> BigDecimal(result).negate()
            "50" -> BigDecimal(result)
            else -> throw IllegalArgumentException("AccountingConfig does not contain a valid 'SIGN'")
        }
    }
}