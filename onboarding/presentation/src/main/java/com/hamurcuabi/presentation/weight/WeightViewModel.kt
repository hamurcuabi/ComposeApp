package com.hamurcuabi.presentation.weight


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
class WeightViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
) : ViewModel() {

    var weight by mutableStateOf("80.0")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onWeightEnter(weight: String) {
        if (weight.length <= 5) {
            this.weight = weight
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val weight = weight.toFloatOrNull() ?: run {
                _uiEvent.send(
                    UiEvent.ShowSnackBar(
                        UiText.StringType(Strings.error_weight_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveWeight(weight)
            _uiEvent.send(UiEvent.Navigate(Route.HEIGHT))
        }
    }
}