package org.wit.diabeticapp.main

import android.app.Application
import android.util.Log
import org.wit.diabeticapp.models.DiabeticMemStore
import org.wit.diabeticapp.models.DiabeticStore

class DiabeticApp : Application() {

    lateinit var diabeticStore: DiabeticStore

    override fun onCreate() {
        super.onCreate()
        diabeticStore = DiabeticMemStore()
        Log.v("Home","Home App started")
    }
}