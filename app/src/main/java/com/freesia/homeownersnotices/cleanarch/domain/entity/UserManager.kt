package com.freesia.homeownersnotices.cleanarch.domain.entity

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.User
import com.freesia.homeownersnotices.cleanarch.domain.usecase.GetUserUseCase
import com.freesia.homeownersnotices.util.Prefs

class UserManager(private val prefs: Prefs) : GetUserUseCase {

    companion object {
        const val KEY_TOKEN = "token"
    }

    init {
        if (User.token == null) User.token = prefs.get(KEY_TOKEN, "")
    }

    override fun invoke() = User
}