package com.freesia.homeownersnotices.cleanarch.domain.usecase

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.LoginResult
import com.freesia.homeownersnotices.cleanarch.domain.repository.LoginRepository
import com.freesia.homeownersnotices.core.exception.Failure
import com.freesia.homeownersnotices.core.functional.Either

interface LoginUseCase {
    suspend operator fun invoke(phone: String): Either<Failure, LoginResult>
}

class LoginUseCaseImpl(private val loginRepository: LoginRepository) : LoginUseCase {
    override suspend fun invoke(phone: String) = loginRepository.login(phone)
}