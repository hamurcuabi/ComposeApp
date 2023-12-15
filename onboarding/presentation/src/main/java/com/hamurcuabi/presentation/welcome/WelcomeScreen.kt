package com.hamurcuabi.presentation.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hamurcuabi.core.navigation.Route
import com.hamurcuabi.core.util.UiEvent
import com.hamurcuabi.core_ui.LocalSpacing
import com.hamurcuabi.core_ui.Strings
import com.hamurcuabi.core_ui.component.ActionButton
import com.hamurcuabi.core_ui.component.WelcomeText

@Composable
fun WelcomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit
) {

    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WelcomeText(
            text = Strings.welcome_text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 65.dp),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            lineHeight = 24.sp
        )
        Spacer(
            modifier = Modifier.height(spacing.spaceMedium)
        )
        ActionButton(
            text = Strings.next,
            onClick = { onNavigate(UiEvent.Navigate(Route.GENDER)) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(
    showSystemUi = true, showBackground = true
)
@Composable
fun WelcomePreview() {
    WelcomeScreen {}
}
