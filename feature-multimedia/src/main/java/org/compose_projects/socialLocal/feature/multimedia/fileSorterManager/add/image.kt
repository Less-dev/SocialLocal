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

import android.content.Context
import android.net.Uri
import android.util.Log
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatglobal
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatinbox
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

private const val TAG = "prueba4"
private const val sampleFile = "sampleImage.jpg"

fun Image(context: Context, uri: Uri, typeChat: String, parentDirCG: File, parentDirCI: File) {
    when(typeChat) {
        chatglobal -> SaveImage(context = context, parentDir = parentDirCG, uri = uri)
        chatinbox ->  SaveImage(context = context, parentDir = parentDirCI, uri = uri)
    }
}



private fun SaveImage(context: Context, parentDir: File, uri: Uri) {
    val newFile = File(parentDir, sampleFile)
    if (!newFile.exists()) {
        try {
            newFile.createNewFile()
            val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
            if (inputStream != null) {
                val outputStream = FileOutputStream(newFile)
                val buffer = ByteArray(1024)
                var bytesRead: Int
                while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                    outputStream.write(buffer, 0, bytesRead)
                }
                inputStream.close()
                outputStream.close()
                Log.d(TAG, "Se creó el archivo $sampleFile correctamente")
            } else {
                Log.e(TAG, "No se pudo abrir el InputStream de la URI")
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e(TAG, "Error: $e")
        }
    }
}