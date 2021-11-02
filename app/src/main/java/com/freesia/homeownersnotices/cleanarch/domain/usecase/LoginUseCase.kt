package com.freesia.homeownersnotices.cleanarch.domain.usecase

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.LoginResult
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Failure
import com.freesia.homeownersnotices.core.functional.Either

interface LoginUseCase {
    suspend operator fun invoke(phone: String): Either<Failure, LoginResult>
}