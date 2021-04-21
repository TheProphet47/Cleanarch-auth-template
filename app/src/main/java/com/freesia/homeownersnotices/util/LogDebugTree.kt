package com.freesia.homeownersnotices.util

import android.util.Log
import timber.log.Timber

object LogDebugTree : Timber.DebugTree() {
    private const val PREFIX = "MainLog."

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        Log.println(priority, PREFIX + tag, message)
    }
}