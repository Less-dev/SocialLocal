package org.compose_projects.socialLocal.feature.multimedia.directoryManager

import android.content.Context
import android.os.Environment
import java.io.File

fun createAppDirectories(
    context: Context,
    media: media
) {
    val baseDir = File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
        media.appName
    )

    if (!baseDir.exists()) {
        baseDir.mkdirs()
    }

    val imagesDir = File(baseDir, media.directoryImages)
    val videosDir = File(baseDir, media.directoryVideos)
    val audioDir = File(baseDir, media.directoryDocuments)
    val documentsDir = File(baseDir, media.directoryAudios)

    if (!imagesDir.exists()) imagesDir.mkdirs()
    if (!videosDir.exists()) videosDir.mkdirs()
    if (!audioDir.exists()) audioDir.mkdirs()
    if (!documentsDir.exists()) documentsDir.mkdirs()

    createChatDirectories(imagesDir, media)
    createChatDirectories(videosDir, media)
    createChatDirectories(audioDir, media)
    createChatDirectories(documentsDir, media)

}


private fun createChatDirectories(parentDir: File, media: media) {
    val chatGlobal = File(parentDir, media.chatGlobal)
    val chatInbox = File(parentDir, media.chatInbox)

    if (!chatGlobal.exists()) chatGlobal.mkdirs()
    if (!chatInbox.exists()) chatInbox.mkdirs()
}