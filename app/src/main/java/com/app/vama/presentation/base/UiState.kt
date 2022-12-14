package com.app.vama.presentation.base

sealed class UiState {
    object Idle : UiState()
    object Loading : UiState()
    class Success<T>(val value: T) : UiState()
    class Error<T>(val error: T) : UiState()
}
