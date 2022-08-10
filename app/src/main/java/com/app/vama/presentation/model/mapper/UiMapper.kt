package com.app.vama.presentation.model.mapper

interface UiMapper<From, To> {
    fun map(from: From): To
}
