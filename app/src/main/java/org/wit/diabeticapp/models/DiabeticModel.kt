package org.wit.diabeticapp.models

import android.os.Parcelable
import com.google.firebase.database.Exclude
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DiabeticModel(
    var uid: String? = "",
    var display: String = "N/A",
    var level: String = "N/A",
    var email: String? = "joe@bloggs.com"
) : Parcelable

{
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to uid,
            "display" to display,
            "level" to level,
            "email" to email
        )
    }
}

