package com.freesia.homeownersnotices.cleanarch.data.network

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Message
import com.freesia.homeownersnotices.cleanarch.domain.repository.MessagesRepository
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Failure
import com.freesia.homeownersnotices.core.functional.Either

class NetworkMessagesRepository : MessagesRepository {

    override suspend fun messages(): Either<Failure, List<Message>> {
        return Either.Left(Failure.ServerError)
    }
}