package com.freesia.homeownersnotices.core.platform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Failure

abstract class BaseViewModel : ViewModel() {

    val failure: MutableLiveData<Failure> = MutableLiveData()

    protected open fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }

}