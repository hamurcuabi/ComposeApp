package com.hamurcuabi.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.hamurcuabi.composeapp.ui.theme.ComposeAppTheme
import com.hamurcuabi.presentation.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
            WelcomeScreen()
            }
        }
    }
}