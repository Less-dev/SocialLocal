package org.compose_projects.socialLocal.feature.multimedia
import android.content.Context
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.CONSTANTS.appname
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.CONSTANTS.audios
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.CONSTANTS.chatglobal
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.CONSTANTS.chatinbox
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.CONSTANTS.documents
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.CONSTANTS.images
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.CONSTANTS.videos
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.configDirectories
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.media

class MultimediaManager {
    fun createDirectories(context: Context) = configDirectories(context = context)

    fun listDirectories() = media(
        appName = appname,
        chatGlobal = chatglobal,
        chatInbox = chatinbox,
        directoryImages = images,
        directoryVideos = videos,
        directoryDocuments = documents,
        directoryAudios = audios
    )


}