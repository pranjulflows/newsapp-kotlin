package com.pranjul.newsapp.extension

import android.content.Context
import android.widget.Toast

object Extensions {

    fun Context.toast(msg:String) { Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()    }
}