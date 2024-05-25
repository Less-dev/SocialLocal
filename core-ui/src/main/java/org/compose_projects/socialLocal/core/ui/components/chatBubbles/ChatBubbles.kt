package org.compose_projects.socialLocal.core.ui.components.chatBubbles

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor

@Composable
fun Bubbles(message: String, hour: String, left: Boolean) {

    val currentColor by SLColor

    Row(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .fillMaxWidth(),
        horizontalArrangement = if (left) Arrangement.Start else Arrangement.End
    ) {
        if (left) {
            // Columna para el triángulo
            Column(
                modifier = Modifier
                    .background(
                        color = currentColor.BackgroundTriangleChatBubblesLeft,
                        shape = TriangleEdgeShape(15, left)
                    )
                    .width(8.dp)
                    .fillMaxHeight()
            ) {}

            // Content
            ContentBubbles(
                message = message,
                hour = hour,
                left = left
            )

        } else {

            // Content
            ContentBubbles(
                message = message,
                hour = hour,
                left = left
            )

            // Columna para el triángulo
            Column(
                modifier = Modifier
                    .background(
                        color = currentColor.BackgroundTriangleChatBubblesRight,
                        shape = TriangleEdgeShape(15, left)
                    )
                    .width(8.dp)
                    .fillMaxHeight()
            ) {}
        }
    }
}


@Composable
private fun ContentBubbles(message: String, hour: String, left: Boolean) {

    val currentColor by SLColor

    if (left) {
        Column(
            modifier = Modifier
                .background(
                    color = currentColor.BackgroundChatBubblesLeft,
                    shape = RoundedCornerShape(4.dp, 4.dp, 4.dp, 0.dp)
                )
        ) {

            Text(
                hour,
                color = currentColor.TextsColor2,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 2.dp, start = 3.dp)
            )

            Text(
                message,
                color = currentColor.TextsColor2,
                modifier = Modifier.padding(5.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    } else {
        Column(
            modifier = Modifier
                .background(
                    color = currentColor.BackgroundChatBubblesRight,
                    shape = RoundedCornerShape(4.dp, 4.dp, 0.dp, 4.dp)
                )
        ) {

            Text(
                hour,
                color = currentColor.TextsColor2,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 3.dp, top = 2.dp)
            )


            Text(
                message,
                color = currentColor.TextsColor2,
                modifier = Modifier.padding(5.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}


private class TriangleEdgeShape(private val offset: Int, private val left: Boolean) : Shape {

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
                lineTo(x = size.width, y = size.height - this@TriangleEdgeShape.offset)
                // Línea diagonal hacia la esquina inferior izquierda
                lineTo(x = size.width - this@TriangleEdgeShape.offset, y = size.height)
                // Cierra el path volviendo al inicio
                close()
            }
            return Outline.Generic(path = trianglePath)
        } else {
            val trianglePath = Path().apply {
                moveTo(x = 0f, y = size.height - offset)
                lineTo(x = 0f, y = size.height)
                lineTo(x = 0f + offset, y = size.height)
            }
            return Outline.Generic(path = trianglePath)
        }
    }
}