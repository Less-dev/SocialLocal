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

package org.compose_projects.socialLocal.core.ui.components.chatBubbles

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialLocal.core.ui.R
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor

@Composable
fun Bubbles(
    message: String? = null,
    image: String? = null,
    video: String? = null,
    hour: String,
    left: Boolean
) {

    Row(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .fillMaxWidth(),
        horizontalArrangement = if (left) Arrangement.Start else Arrangement.End
    ) {
        if (left) {
            TriangleChatBubbles(left = left)
            ContentBubbles(
                left = left,
                title = {
                    CurrentTitle(
                        imageProfile = "",
                        hour = hour,
                        left = left
                    )
                }
            ) {
                CurrentContent(message, image, video)
            }

        } else {
            ContentBubbles(
                left = left,
                title = {
                    CurrentTitle(
                        imageProfile = "",
                        hour = hour,
                        left = left
                    )
                }
            ) {
                CurrentContent(message, image, video)
            }
            TriangleChatBubbles(left = left)
        }
    }
}


@Composable
private fun CurrentTitle(
    imageProfile: String,
    hour: String,
    left: Boolean
) {

    val currentColor by SLColor

    if (left) {
        Row(
            modifier = Modifier.width(IntrinsicSize.Max),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                hour,
                color = currentColor.TextsColor2,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(top = 2.dp, start = 4.dp)
            )

            Text(
                "Pedro",
                color = currentColor.TextsColor2,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(end = 4.dp, top = 2.dp)
            )
        }
    } else {
        Row(
            modifier = Modifier.width(IntrinsicSize.Max),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Juan",
                color = currentColor.TextsColor2,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(top = 2.dp, start = 4.dp)
            )

            Text(
                hour,
                color = currentColor.TextsColor2,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(end = 4.dp, top = 2.dp)
            )

        }
    }
}


@Composable
fun CurrentContent(
    message: String? = null,
    image: String? = null,
    video: String? = null,
) {

    val currentColor by SLColor

    if (message != null) {
        Text(
            message,
            color = currentColor.TextsColor2,
            modifier = Modifier.padding(5.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
    } else if (image != null) {

        val imageUri = when (image) {
            imageURIs.uri1 -> R.drawable.meme1
            imageURIs.uri2 -> R.drawable.meme2
            imageURIs.uri3 -> R.drawable.meme3
            else -> {
                R.drawable.meme1
            }
        }

        Box(
            modifier = Modifier
                .size(300.dp)
                .padding(8.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(color = currentColor.BackgroundColor.copy(alpha = 0.8F))
        ) {

            Image(
                painter = painterResource(
                    id = imageUri
                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()

            )

        }
    } else if (video != null) {
        //visualice video
    }


}


@Composable
private fun ContentBubbles(
    left: Boolean,
    title: @Composable () -> Unit,
    content: @Composable () -> Unit
) {

    val currentColor by SLColor

    if (left) {
        Column(
            modifier = Modifier
                .background(
                    color = currentColor.BackgroundChatBubblesLeft,
                    shape = RoundedCornerShape(4.dp, 4.dp, 4.dp, 0.dp)
                )
        ) {
            title()
            content()
        }
    } else {
        Column(
            modifier = Modifier
                .background(
                    color = currentColor.BackgroundChatBubblesRight,
                    shape = RoundedCornerShape(4.dp, 4.dp, 0.dp, 4.dp)
                )
        ) {
            title()
            content()
        }
    }
}

@Composable
private fun TriangleChatBubbles(left: Boolean) {
    val currentColor by SLColor

    Column(
        modifier = Modifier
            .background(
                color = if (left) currentColor.BackgroundTriangleChatBubblesLeft else currentColor.BackgroundTriangleChatBubblesRight,
                shape = TriangleEdgeShape(20, left)
            )
            .width(8.dp)
            .fillMaxHeight()
    ) {}
}

private class TriangleEdgeShape(
    private val sizeTriangle: Int,
    private val left: Boolean
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        if (left) {
            val trianglePath = Path().apply {
                // Empieza en la esquina inferior derecha
                moveTo(x = size.width, y = size.height)
                // Línea hacia arriba en el mismo eje x
                lineTo(x = size.width, y = size.height - this@TriangleEdgeShape.sizeTriangle)
                // Línea diagonal hacia la esquina inferior izquierda
                lineTo(x = size.width - this@TriangleEdgeShape.sizeTriangle, y = size.height)
                // Cierra el path volviendo al inicio
                close()
            }
            return Outline.Generic(path = trianglePath)
        } else {
            val trianglePath = Path().apply {
                moveTo(x = 0f, y = size.height - this@TriangleEdgeShape.sizeTriangle)
                lineTo(x = 0f, y = size.height)
                lineTo(x = 0f + this@TriangleEdgeShape.sizeTriangle, y = size.height)
            }
            return Outline.Generic(path = trianglePath)
        }
    }
}