package org.wit.diabeticapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DiabeticModel(
    var id: Long = 0,
    val displayno: String = "N/A") : Parcelable

