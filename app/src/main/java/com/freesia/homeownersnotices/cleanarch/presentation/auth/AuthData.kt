package com.freesia.homeownersnotices.cleanarch.presentation.auth

sealed class UiLoginResult {

    object True : UiLoginResult()

    data class False(
        val phoneMessage: String? = null,
    ) : UiLoginResult()
}