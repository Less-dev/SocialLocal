package org.compose_projects.socialLocal.core.ui.components.videoPlayer.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.sanghun.compose.video.uri.VideoPlayerMediaItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.compose_projects.socialLocal.core.ui.R

class ChatGlobal: ViewModel() {
    private val _mediaItem = MutableStateFlow<List<VideoPlayerMediaItem>>(listOf(
        VideoPlayerMediaItem.RawResourceMediaItem(
            resourceId = R.raw.video,
        )
    ))
    val mediaItem: StateFlow<List<VideoPlayerMediaItem>> get() = _mediaItem

    fun addMediaItem(mediaItem: VideoPlayerMediaItem) {
        // Actualizar el valor de _mediaItemList
        _mediaItem.value += mediaItem
    }

    private val _stateVisibility = MutableStateFlow(false)
    val stateVisibility: StateFlow<Boolean> get() = _stateVisibility

    fun changeStateValue(value: Boolean) =
        viewModelScope.launch {
            _stateVisibility.value = value
        }

}