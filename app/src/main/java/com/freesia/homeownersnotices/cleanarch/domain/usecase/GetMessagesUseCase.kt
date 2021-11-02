package com.freesia.homeownersnotices.cleanarch.domain.usecase

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Message
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Failure
import com.freesia.homeownersnotices.core.functional.Either

interface GetMessagesUseCase {
    suspend operator fun invoke(): Either<Failure, List<Message>>
}