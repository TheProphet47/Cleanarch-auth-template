package com.freesia.homeownersnotices.cleanarch.presentation

import com.freesia.homeownersnotices.cleanarch.domain.entity.model.LoginFailure
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.LoginResult
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Message
import com.freesia.homeownersnotices.cleanarch.presentation.auth.UiLoginResult
import com.freesia.homeownersnotices.cleanarch.presentation.main.UiMessageData

fun toUiLoginTrue(response: LoginResult) = UiLoginResult.True
fun toUiLoginFalse(response: LoginFailure) = UiLoginResult.False(response.phoneError)

fun toUiMessage(message: Message) = UiMessageData(
    message.text, message.date.toString(), !message.isChecked
)