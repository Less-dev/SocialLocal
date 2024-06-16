package org.compose_projects.socialLocal.feature.multimedia


import android.content.Context
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.appname
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.configDirectories
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.listAppDirectories


class MultimediaManager(private val context: Context) {
    fun createDirectories() = configDirectories(context = context)
    fun treeOfDirectories() = listAppDirectories(context = context, appName = appname)

}