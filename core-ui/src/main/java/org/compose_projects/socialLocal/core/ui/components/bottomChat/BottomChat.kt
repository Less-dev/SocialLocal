package org.compose_projects.socialLocal.core.ui.components.bottomChat

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BottomChat(
    modifier: Modifier = Modifier,
    cameraAction: (() -> Unit)? = null,
    fileAction: (() -> Unit)? = null,
    bottomChatViewModel: BottomChatViewModel = viewModel()
) {
    val value = bottomChatViewModel.text.collectAsState().value

    OutlinedTextField(
        value = value,
        onValueChange = { bottomChatViewModel.changeText(it) },
        modifier = modifier,
        shape = RoundedCornerShape(15.dp)
        )

}