package com.example.kotlineventprocessor.query

import java.util.*

enum class QueryableEntity {
    CONTRACT,
    CONTRACTPART,
    BENEFICIARY;


    companion object {
        fun contains(value: String?): Boolean {
            return Arrays.stream(entries.toTypedArray())
                .anyMatch { e: QueryableEntity? -> e!!.name.equals(value, ignoreCase = true) }
        }
    }
}