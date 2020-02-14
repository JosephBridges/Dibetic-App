package org.wit.diabeticapp.models

interface DiabeticStore {
    fun findAll() : List<DiabeticModel>
    fun findById(id: Long) : DiabeticModel?
    fun create(diabetic: DiabeticModel)
    //fun update(donation: DonationModel)
    //fun delete(donation: DonationModel)
}