package org.wit.diabeticapp.models

import android.util.Log

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

