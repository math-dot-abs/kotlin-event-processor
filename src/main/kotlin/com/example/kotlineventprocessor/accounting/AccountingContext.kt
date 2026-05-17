package com.example.kotlineventprocessor.accounting

import com.example.kotlineventprocessor.event.Beneficiary
import com.example.kotlineventprocessor.event.Contract
import com.example.kotlineventprocessor.event.ContractPart

data class AccountingContext(
    val contract: Contract,
    var beneficiary: Beneficiary? = null,
    var contractPart: ContractPart? = null
)