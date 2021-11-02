package com.freesia.homeownersnotices.di

import com.freesia.homeownersnotices.cleanarch.data.network.NetworkLoginRepository
import com.freesia.homeownersnotices.cleanarch.data.network.NetworkMessagesRepository
import com.freesia.homeownersnotices.cleanarch.domain.entity.UserManager
import com.freesia.homeownersnotices.cleanarch.domain.repository.LoginRepository
import com.freesia.homeownersnotices.cleanarch.domain.repository.MessagesRepository
import com.freesia.homeownersnotices.cleanarch.domain.usecase.*
import com.freesia.homeownersnotices.cleanarch.domain.usecase.impl.DomainGetMessagesUseCase
import com.freesia.homeownersnotices.cleanarch.domain.usecase.impl.DomainLoginUseCase
import com.freesia.homeownersnotices.cleanarch.presentation.auth.AuthViewModel
import com.freesia.homeownersnotices.cleanarch.presentation.main.MainViewModel
import com.freesia.homeownersnotices.cleanarch.presentation.root.StartViewModel
import com.freesia.homeownersnotices.util.Prefs
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


object Di {

    val platform = module {
        single { Prefs(androidContext()) }
    }

    val user = module {
        single<GetUserUseCase> { UserManager(get()) }
    }


    val network = module {

    }


    val app = module {
        single<LoginRepository> { NetworkLoginRepository() }
        single<MessagesRepository> { NetworkMessagesRepository() }

        single<LoginUseCase> { DomainLoginUseCase(get()) }
        single<GetMessagesUseCase> { DomainGetMessagesUseCase(get()) }
    }


    val viewModels = module {
        single { StartViewModel(get()) }
        single { MainViewModel(get()) }
        single { AuthViewModel(get()) }
    }

}