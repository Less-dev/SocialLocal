package org.compose_projects.socialLocal.core.ui.components.videoPlayer.viewModels

import androidx.lifecycle.ViewModel
import io.sanghun.compose.video.uri.VideoPlayerMediaItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.compose_projects.socialLocal.core.ui.R

class ChatInbox: ViewModel() {

    private val _mediaItemList = MutableStateFlow<List<VideoPlayerMediaItem>>(listOf(
        VideoPlayerMediaItem.RawResourceMediaItem(
            resourceId = R.raw.video,
        )
    ))
    val mediaItemList: StateFlow<List<VideoPlayerMediaItem>> get() = _mediaItemList

    fun addMediaItem(mediaItem: VideoPlayerMediaItem) {
        // Actualizar el valor de _mediaItemList
        _mediaItemList.value += mediaItem
    }
}