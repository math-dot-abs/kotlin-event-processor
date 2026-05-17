package com.example.kotlineventprocessor.accounting

class ConfigResolver {
    fun resolve(baseContext: AccountingContext, configs: List<AccountingConfig>): List<AccountingContext> {
        TODO("Should call method and pass baseContext and each single AccountingConfig." +
                "Method could then be implemented with Coroutines to allow parallel Entity identification," +
                "whether that's really effective or not is debatable." +
                "Consider making ConfigResolver static, if possible." +
                "Best would be to no longer need some sort of state for the Resolver (No EntityMap)")
    }
}