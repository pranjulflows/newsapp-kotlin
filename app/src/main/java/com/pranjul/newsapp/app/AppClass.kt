package com.pranjul.newsapp.app

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppClass : Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        val Context.context: AppClass
            get() = applicationContext as AppClass

        lateinit var instance: AppClass
    }
}
