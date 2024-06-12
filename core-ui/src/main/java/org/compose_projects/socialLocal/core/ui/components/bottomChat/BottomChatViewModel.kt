package org.compose_projects.socialLocal.core.ui.components.bottomChat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BottomChatViewModel: ViewModel() {
    private val _text = MutableStateFlow("")
    val text: StateFlow<String> get() = _text

    fun changeText(input: String) =
        viewModelScope.launch {
            _text.value = input
        }
}