package com.freesia.homeownersnotices.cleanarch.data.network

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.LoginResult
import com.freesia.homeownersnotices.cleanarch.domain.repository.LoginRepository
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Failure
import com.freesia.homeownersnotices.core.functional.Either

class NetworkLoginRepository : LoginRepository {

    override suspend fun login(phone: String): Either<Failure, LoginResult> {
        return Either.Right(LoginResult("token"))
    }
}