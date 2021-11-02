package com.freesia.homeownersnotices.cleanarch.domain.usecase.impl

import com.freesia.homeownersnotices.cleanarch.domain.repository.LoginRepository
import com.freesia.homeownersnotices.cleanarch.domain.usecase.LoginUseCase

class DomainLoginUseCase(private val loginRepository: LoginRepository) : LoginUseCase {
    override suspend fun invoke(phone: String) = loginRepository.login(phone)
}