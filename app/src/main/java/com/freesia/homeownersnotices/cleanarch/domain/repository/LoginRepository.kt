package com.freesia.homeownersnotices.cleanarch.domain.repository

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.LoginResult
import com.freesia.homeownersnotices.core.exception.Failure
import com.freesia.homeownersnotices.core.functional.Either

interface LoginRepository {
    suspend fun login(phone: String): Either<Failure, LoginResult>
}