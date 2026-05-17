package com.example.kotlineventprocessor.accounting

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/**
 * Unlike Java, Kotlin non-nullable fields have no implicit default — the compiler requires every field to be initialized.
 * Defaults here allow plugin.jpa to generate the no-arg constructor JPA needs for reflection-based instantiation.
 * Nullable columns are typed as "String?" with null defaults instead, as they are optional in our DB.
 */
@Entity
data class AccountingConfig(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val processingType: Int = 0,
    val query: String = "",
    val accountId: String = "",
    val sign: String = "",
    val rLM: String = "",
    val mprocess: String = "",
    val sprocess: String = "",
    val sMaccount: String = "",
    val hMaccount: String = "",
    val productGroup: String = "",
    val insuranceType: String = "",
    val stockType: String? = null,
    val claimType: String? = null,
    val riskType: String? = null,
    val insuranceTypeLong: String? = null
)