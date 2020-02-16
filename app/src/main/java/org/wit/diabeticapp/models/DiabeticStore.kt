package org.wit.diabeticapp.models

interface DiabeticStore {
    fun findAll() : List<DiabeticModel>
    fun findById(id: Long) : DiabeticModel?
    fun create(diabetic: DiabeticModel)
}