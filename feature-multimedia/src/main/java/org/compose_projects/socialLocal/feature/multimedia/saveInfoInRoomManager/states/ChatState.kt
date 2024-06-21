package org.compose_projects.socialLocal.feature.multimedia.saveInfoInRoomManager.states

import org.compose_projects.socialLocal.core.data.data.ChatProvider

sealed interface ChatState {
    data object Loading : ChatState
    data class Error(val throwable: Throwable) : ChatState
    data class Success(val data: List<ChatProvider>) : ChatState
}
