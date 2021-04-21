package com.freesia.homeownersnotices.cleanarch.domain.entity.model

import java.util.*

data class Message(
    val text: String,
    val date: Date,
    val isChecked: Boolean
)
