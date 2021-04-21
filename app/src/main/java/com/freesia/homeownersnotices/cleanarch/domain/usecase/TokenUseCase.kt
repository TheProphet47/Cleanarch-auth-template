package com.freesia.homeownersnotices.cleanarch.domain.usecase

interface TokenUseCase {
    val token: String?
    fun set(token: String?, isSave: Boolean)
    suspend fun refresh()
}