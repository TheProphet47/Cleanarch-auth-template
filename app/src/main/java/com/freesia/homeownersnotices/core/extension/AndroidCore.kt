package com.freesia.homeownersnotices.core.extension

import android.content.Context
import android.widget.Toast

val Context.screenWidth: Int
    get() = resources.displayMetrics.widthPixels

val Context.screenHeight: Int
    get() = resources.displayMetrics.heightPixels

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg,
        Toast.LENGTH_SHORT).show()
}