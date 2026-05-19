package com.example.kotlineventprocessor.action

import com.example.kotlineventprocessor.mapper.MapperRegistry
import com.example.kotlineventprocessor.operation.OperationInterface

class DefaultAction(mapperRegistry: MapperRegistry, operations: List<OperationInterface>) : ActionBase(mapperRegistry, operations) {

    override fun performAdditionally() {}

}