package com.example.kotlineventprocessor.query

import java.lang.reflect.Method
import java.util.*
import java.util.Locale.getDefault

object EntityReader {
    fun read(query: Query, entity: Any): String {
        val assumedFunctionName = "get" + query.fieldName.toString().lowercase(getDefault())
        val clazz: Class<*> = entity.javaClass
        val getterFunctionName: String = getActualFunctionName(clazz, assumedFunctionName)
        try {
            val returnedValue = clazz.getDeclaredMethod(getterFunctionName).invoke(entity)
            return returnedValue?.toString() ?: "0"
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun getActualFunctionName(clazz: Class<*>, assumedFunctionName: String?): String {
        return Arrays.stream(clazz.getDeclaredMethods())
            .map { obj: Method? -> obj!!.name }
            .filter { internalMethodName: String -> internalMethodName.lowercase(getDefault()) == assumedFunctionName }
            .toList()
            .first()
    }
}