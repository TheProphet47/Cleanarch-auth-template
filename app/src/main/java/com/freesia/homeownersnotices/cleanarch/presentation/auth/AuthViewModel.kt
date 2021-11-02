package com.freesia.homeownersnotices.cleanarch.presentation.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.LoginFailure
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.LoginResult
import com.freesia.homeownersnotices.cleanarch.domain.usecase.LoginUseCase
import com.freesia.homeownersnotices.cleanarch.presentation.toUiLoginFalse
import com.freesia.homeownersnotices.cleanarch.presentation.toUiLoginTrue
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Failure
import com.freesia.homeownersnotices.core.extension.mapWith
import com.freesia.homeownersnotices.core.platform.BaseViewModel
import kotlinx.coroutines.launch

class AuthViewModel(private val loginUseCase: LoginUseCase) : BaseViewModel() {

    val loginResult = MutableLiveData<UiLoginResult>()

    fun login(phone: String) {
        viewModelScope.launch {
            loginUseCase(phone).bind(::handleFailure, ::handleSuccess)
        }
    }

    private fun handleSuccess(result: LoginResult) {
        loginResult.value = result.mapWith(::toUiLoginTrue)
    }

    override fun handleFailure(failure: Failure) = when(failure) {
        is LoginFailure -> loginResult.value = failure.mapWith(::toUiLoginFalse)
        else -> super.handleFailure(failure)
    }
}