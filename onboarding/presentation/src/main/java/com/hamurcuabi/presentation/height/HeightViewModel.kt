package com.hamurcuabi.presentation.height


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamurcuabi.core.domain.prefs.Preferences
import com.hamurcuabi.core.navigation.Route
import com.hamurcuabi.core.util.UiEvent
import com.hamurcuabi.core.util.UiText
import com.hamurcuabi.core_ui.Strings
import com.hamurcuabi.domain.FilterOutDigits
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
): ViewModel() {

    var height by mutableStateOf("180")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onHeightEnter(height: String) {
        if(height.length <= 3) {
            this.height = filterOutDigits(height)
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val height = height.toIntOrNull() ?: run {
                _uiEvent.send(
                    UiEvent.ShowSnackBar(
                        UiText.StringType(Strings.error_height_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveHeight(height)
            _uiEvent.send(UiEvent.Navigate(Route.WEIGHT))
        }
    }
}