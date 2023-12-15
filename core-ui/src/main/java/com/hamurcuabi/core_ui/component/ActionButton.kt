package com.hamurcuabi.core_ui.component

import android.os.SystemClock
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
private const val DEBOUNCE = 600L
@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    var lastClickTime by remember { mutableStateOf(0L) }

    Button(
        onClick = {
            if (SystemClock.elapsedRealtime() - lastClickTime > DEBOUNCE) {
                onClick.invoke()
                lastClickTime = SystemClock.elapsedRealtime()
            }
        },
        modifier = modifier,
        enabled = isEnabled,
        shape = RoundedCornerShape(100.dp)
    ) {

        WelcomeText(
            text = text,
            modifier = Modifier
                .fillMaxWidth(0.5f),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface
        )
    }

}