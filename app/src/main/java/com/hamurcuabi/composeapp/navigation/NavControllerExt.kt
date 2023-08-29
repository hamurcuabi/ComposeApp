package com.hamurcuabi.composeapp.navigation

import androidx.navigation.NavController
import com.hamurcuabi.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}