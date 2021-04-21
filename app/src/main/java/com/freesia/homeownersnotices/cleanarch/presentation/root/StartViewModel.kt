package com.freesia.homeownersnotices.cleanarch.presentation.root

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.freesia.homeownersnotices.cleanarch.domain.usecase.GetUserUseCase
import com.freesia.homeownersnotices.core.platform.BaseViewModel

class StartViewModel(private val getUserUseCase: GetUserUseCase) : BaseViewModel() {

    val isUserLoggedIn: LiveData<Boolean> = liveData { emit(getUserUseCase().isAuth) }

}