package com.ciechu.brewdogrecipes.core.base

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}