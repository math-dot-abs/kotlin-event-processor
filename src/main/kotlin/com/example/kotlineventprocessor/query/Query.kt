package de.inter.lv.exkasso.event.processor.entity.excelQuery

class Query(tableName: QueryableEntities?, fieldName: String?, operation: String?, value: String?) {
    val tableName: QueryableEntities?
    val fieldName: String?
    val operation: String?
    val value: String?

    init {
        this.tableName = tableName
        this.fieldName = fieldName
        this.operation = operation
        this.value = value
    }
}