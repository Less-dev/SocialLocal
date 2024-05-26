package org.compose_projects.socialLocal.core.ui.components.prev_profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor

@Composable
internal fun ContentPreview(nameProfile: String) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(10.dp)
    ) {
        CurrentTitle(nameProfile = nameProfile)
        CurrentContent()
    }
}

@Composable
private fun CurrentTitle(nameProfile: String) {
    val currentColor by SLColor

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = nameProfile,
            style = TextStyle(
                color = currentColor.TextsColor2,
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraBold
            )
        )
    }

}

@Composable
private fun CurrentContent() {

}