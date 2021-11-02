package com.freesia.homeownersnotices.cleanarch.domain.entity.model

data class LoginResult(
    val token: String
)

data class LoginFailure(
    val phoneError: String?,
) : Failure.Feature()
