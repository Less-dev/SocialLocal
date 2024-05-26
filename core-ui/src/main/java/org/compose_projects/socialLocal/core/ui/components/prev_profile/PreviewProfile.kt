package org.compose_projects.socialLocal.core.ui.components.prev_profile

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewProfile(
    state: Boolean,
    nameProfile: String,
    onDismissRequest: () -> Unit
) {

    val currentColor by SLColor

    if (state) {
        ModalBottomSheet(
            onDismissRequest = {
                onDismissRequest()
            },
            containerColor = currentColor.BackgroundColor,
            modifier = Modifier.fillMaxHeight(0.9F)
        ) {
            // content
            ContentPreview(nameProfile = nameProfile)
        }
    }

}

