package de.inter.lv.exkasso.event.processor.entity.excelQuery

import java.util.*

enum class QueryableEntities {
    SSTEXKASSOVERTRAG,
    SSTEXKASSOVERTRAGSTEIL,
    SSTEXKASSOLEISTUNGSEMPFAENGER,
    MONATSSATZ;


    companion object {
        fun contains(value: String?): Boolean {
            return Arrays.stream(entries.toTypedArray())
                .anyMatch { e: QueryableEntities? -> e!!.name.equals(value, ignoreCase = true) }
        }
    }
}