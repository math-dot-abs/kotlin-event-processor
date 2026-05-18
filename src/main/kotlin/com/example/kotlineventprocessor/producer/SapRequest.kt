package com.example.kotlineventprocessor.producer

import java.time.LocalDateTime;

data class SapRequest(
    val businessPartnerNumber : String,
    val contractId : String,
    var amount: Double,
    val mProcess: String?,
    val sProcess: String?,
    val bankRoutingNumber : String,
    val insuranceType : String?,
    val claimType : String?,
    val riskType : String?,
    val validAsOf : LocalDateTime?,
    val validUntil : LocalDateTime?,
    val productGroup : String?,
    val insuranceObject : String,
    val businessPartner : String,
){
    fun negateBetrag() {
        this.amount = this.amount.unaryMinus()
    }
