package org.wit.diabeticapp.models

import android.util.Log

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class DiabeticMemStore : DiabeticStore {

    val diabetics = ArrayList<DiabeticModel>()

    override fun findAll(): List<DiabeticModel> {
        return diabetics
    }

    override fun findById(id:Long) : DiabeticModel? {
        val foundDiabetic: DiabeticModel? = diabetics.find { it.id == id }
        return foundDiabetic
    }

    override fun create(diabetic: DiabeticModel) {
        diabetic.id = getId()
        diabetics.add(diabetic)
        logAll()
    }

    fun logAll() {
        Log.v("Diabetic","** Diabetics List **")
        diabetics.forEach { Log.v("Diabetic","$it") }
    }
}
