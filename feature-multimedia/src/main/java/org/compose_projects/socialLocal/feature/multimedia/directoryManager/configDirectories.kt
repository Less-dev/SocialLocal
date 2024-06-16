package org.compose_projects.socialLocal.feature.multimedia.directoryManager

import android.content.Context
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.appname
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.audios
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatglobal
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatinbox
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.documents
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.images
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.videos

internal fun configDirectories(context: Context) {
    //creating full directories of Social Local
    createAppDirectories(
        context = context,
        media = media(
            appName = appname,
            chatGlobal = chatglobal,
            chatInbox = chatinbox,
            directoryImages = images,
            directoryVideos = videos,
            directoryDocuments = documents,
            directoryAudios = audios
        )
    )
}