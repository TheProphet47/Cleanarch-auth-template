package com.freesia.homeownersnotices.cleanarch.presentation.main

data class UiMessageData(
    val text: String,
    val date: String,
    val isBacklight: Boolean = false
)