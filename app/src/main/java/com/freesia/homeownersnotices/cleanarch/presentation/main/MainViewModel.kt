package com.freesia.homeownersnotices.cleanarch.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Message
import com.freesia.homeownersnotices.cleanarch.domain.usecase.GetMessagesUseCase
import com.freesia.homeownersnotices.cleanarch.presentation.toUiMessage
import com.freesia.homeownersnotices.core.extension.mapListWith
import com.freesia.homeownersnotices.core.platform.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(private val getMessagesUseCase: GetMessagesUseCase) : BaseViewModel() {

    val messages = MutableLiveData<List<UiMessageData>>()

    fun requestMessages() {
        viewModelScope.launch {
            getMessagesUseCase().bind(::handleFailure, ::handleSuccess)
        }
    }

    private fun handleSuccess(result: List<Message>) {
        messages.value = result.mapListWith(::toUiMessage)
    }
}