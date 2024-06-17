/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.add

import android.net.Uri
import android.os.Environment
import android.util.Log
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.media
import java.io.File
import java.io.FileWriter
import java.io.IOException

private const val TAG = "prueba4"
private const val sampleFile = "file.txt"
internal fun Image(uri: Uri, typeChat: String) {

    //test
    //Log.d(TAG, "Chat: $typeChat, uri -> $uri")

    val newFile = File("parentDir", sampleFile)
    if (!newFile.exists()) {
        try {
            newFile.createNewFile()
            // Write content in the file
            val fileWriter = FileWriter(newFile)
            fileWriter.write("Contenido del archivo")
            fileWriter.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


}