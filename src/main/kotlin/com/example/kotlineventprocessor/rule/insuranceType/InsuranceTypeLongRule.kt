package com.example.kotlineventprocessor.rule.insuranceType

import com.example.kotlineventprocessor.accounting.AccountingContext
import com.example.kotlineventprocessor.query.EntityReader.read
import com.example.kotlineventprocessor.query.Query
import com.example.kotlineventprocessor.rule.RuleInterface
import com.example.kotlineventprocessor.query.QueryUtils
import com.example.kotlineventprocessor.query.QueryUtils.convertStringToTableAndField
import com.example.kotlineventprocessor.query.QueryUtils.getQueries
import com.example.kotlineventprocessor.query.QueryableEntity
import org.springframework.stereotype.Component

@Component
class InsuranceTypeLongRule : RuleInterface {

    @Override
    override fun apply(context: AccountingContext) {
        val suppliedInsuranceTypeLongRule: String? = context.accountingConfig!!.insuranceTypeLong
        if (suppliedInsuranceTypeLongRule.isNullOrBlank()) return

        if (QueryableEntity.contains(convertStringToTableAndField(suppliedInsuranceTypeLongRule)[0])) {
            val queries: List<Query> = getQueries(suppliedInsuranceTypeLongRule)
            val entity = context.getEntityByName(queries.last().tableName)!!
            val result = read(queries.last(), entity)
            context.insuranceTypeLong = result
        } else {
            context.insuranceTypeLong = suppliedInsuranceTypeLongRule
        }
    }
}