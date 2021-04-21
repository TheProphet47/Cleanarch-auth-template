package com.freesia.homeownersnotices.cleanarch.domain.entity.model

object User {

    var token: String? = null

    val isAuth: Boolean
        get() = !token.isNullOrEmpty()

}