package org.compose_projects.socialLocal.core.ui.components.videoPlayer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import io.sanghun.compose.video.RepeatMode
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.controller.VideoPlayerControllerConfig
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

@Composable
fun VideoScreen(videoViewModel: VideoViewModel = viewModel()) {

    val mediaItemList = videoViewModel.mediaItemList.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        Video(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            mediaItems = mediaItemList
        )
    }

}


@Composable
private fun Video(
    modifier: Modifier = Modifier,
    mediaItems: List<VideoPlayerMediaItem>
) {
    VideoPlayer(
        mediaItems = mediaItems,
        handleLifecycle = true,
        autoPlay = true,
        usePlayerController = true,
        enablePip = true,
        handleAudioFocus = true,
        controllerConfig = VideoPlayerControllerConfig(
            showSpeedAndPitchOverlay = false,
            showSubtitleButton = false,
            showCurrentTimeAndTotalTime = true,
            showBufferingProgress = false,
            showForwardIncrementButton = true,
            showBackwardIncrementButton = true,
            showBackTrackButton = true,
            showNextTrackButton = true,
            showRepeatModeButton = true,
            showFullScreenButton = true,
            controllerShowTimeMilliSeconds = 5_000,
            controllerAutoShow = true,
        ),
        volume = 0.5f,  // volume 0.0f to 1.0f
        repeatMode = RepeatMode.NONE,       // or RepeatMode.ALL, RepeatMode.ONE
        onCurrentTimeChanged = { },
        playerInstance = { },
        modifier = modifier
    )
}