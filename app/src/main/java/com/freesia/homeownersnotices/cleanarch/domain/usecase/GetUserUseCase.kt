package com.freesia.homeownersnotices.cleanarch.domain.usecase

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.User

interface GetUserUseCase {
    operator fun invoke(): User
}