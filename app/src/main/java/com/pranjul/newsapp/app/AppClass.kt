package com.pranjul.newsapp.app

import android.app.Application
import android.content.Context
import com.devnagritranslationsdk.DevNagriTranslationSdk
import com.pranjul.newsapp.R
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppClass : Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
        val strings = R.string::class.java.fields.map { it.name }
        DevNagriTranslationSdk.init(applicationContext, "devnagri_5dc66da6b63711eca521021b05a03360" ,strings)

    }

    companion object {
        val Context.context: AppClass
            get() = applicationContext as AppClass

        lateinit var instance: AppClass
    }
}
