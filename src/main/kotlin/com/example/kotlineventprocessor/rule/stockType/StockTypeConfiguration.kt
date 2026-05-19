package com.example.kotlineventprocessor.rule.stockType

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class StockTypeConfiguration(
    @Id val type: String = "",
    val legacyIndicator: Boolean = false,
    val statementGeneration: List<Int> = listOf(),
    val inStatementGeneration: String = "",
    val ratingGender: Int = 0,
    val inRatingGender: String = ""
) {

    fun getInStatementGeneration(): Boolean {
        return inStatementGeneration != NOT_OPERATION;
    }

    fun getInRatingGender(): Boolean {
        return inRatingGender != NOT_OPERATION;
    }

    companion object {
        const val NOT_OPERATION = "NOT"
    }

}
