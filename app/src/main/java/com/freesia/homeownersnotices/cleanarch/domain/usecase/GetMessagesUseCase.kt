package com.freesia.homeownersnotices.cleanarch.domain.usecase

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Message
import com.freesia.homeownersnotices.cleanarch.domain.repository.MessagesRepository
import com.freesia.homeownersnotices.core.exception.Failure
import com.freesia.homeownersnotices.core.functional.Either

interface GetMessagesUseCase {
    suspend operator fun invoke(): Either<Failure, List<Message>>
}

class GetMessagesUseCaseImpl(private val messagesRepository: MessagesRepository) : GetMessagesUseCase {
    override suspend fun invoke() = messagesRepository.messages()
}