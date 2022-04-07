package com.pranjul.newsapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.devnagritranslationsdk.DevNagriTranslationSdk
import com.pranjul.newsapp.R
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun getDelegate(): AppCompatDelegate {
        return DevNagriTranslationSdk.fetchAppDelegate(this, super.getDelegate())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val locale = Locale("hi");
        DevNagriTranslationSdk.updateAppLocale(this , locale)

        setContentView(R.layout.activity_main)
        DevNagriTranslationSdk.getTranslationOfString("Hello there, I am Pranjul, I am from India")
        { translation ->
            Log.e("TAG", "onCreate: $translation" )
        }
    }
}