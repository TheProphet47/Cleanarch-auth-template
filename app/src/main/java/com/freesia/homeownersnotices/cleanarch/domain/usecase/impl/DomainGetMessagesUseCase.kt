package com.freesia.homeownersnotices.cleanarch.domain.usecase.impl

import com.freesia.homeownersnotices.cleanarch.domain.repository.MessagesRepository
import com.freesia.homeownersnotices.cleanarch.domain.usecase.GetMessagesUseCase

class DomainGetMessagesUseCase(private val messagesRepository: MessagesRepository) :
    GetMessagesUseCase {
    override suspend fun invoke() = messagesRepository.messages()
}