package com.freesia.homeownersnotices.cleanarch.domain.entity.model

import com.freesia.homeownersnotices.core.exception.Failure

data class LoginResult(
    val token: String
)

data class LoginFailure(
    val phoneError: String?,
) : Failure.Feature()
