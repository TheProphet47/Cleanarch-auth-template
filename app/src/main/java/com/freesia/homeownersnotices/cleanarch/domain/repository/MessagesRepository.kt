package com.freesia.homeownersnotices.cleanarch.domain.repository

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Message
import com.freesia.homeownersnotices.core.exception.Failure
import com.freesia.homeownersnotices.core.functional.Either

interface MessagesRepository {
    suspend fun messages(): Either<Failure, List<Message>>
}