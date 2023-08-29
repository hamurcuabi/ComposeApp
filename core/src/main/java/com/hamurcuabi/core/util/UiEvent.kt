package com.hamurcuabi.core.util

sealed interface UiEvent {

    data class Navigate(val route: String) : UiEvent
    object NavigateUp : UiEvent
}