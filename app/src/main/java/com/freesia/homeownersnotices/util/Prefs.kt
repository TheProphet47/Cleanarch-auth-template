package com.freesia.homeownersnotices.util

import android.content.Context
import androidx.core.content.edit
import com.freesia.homeownersnotices.BuildConfig

class Prefs(context: Context) {

    private val preferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)


    fun put(key: String, value: Any) = preferences.edit {
        when (value) {
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Boolean -> putBoolean(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            else -> error("Only primitive types can be stored in SharedPreferences")
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> get(key: String, default: T): T = when (default) {
        is String -> preferences.getString(key, default) as T
        is Int -> preferences.getInt(key, default) as T
        is Boolean -> preferences.getBoolean(key, default) as T
        is Long -> preferences.getLong(key, default) as T
        is Float -> preferences.getFloat(key, default) as T
        else -> error("Only primitive types can be stored in SharedPreferences")
    }

    fun clear(key: String) = preferences.edit().remove(key).apply()
    fun clear() = preferences.edit().clear().apply()
}