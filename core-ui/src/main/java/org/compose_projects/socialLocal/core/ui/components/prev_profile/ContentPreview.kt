package org.compose_projects.socialLocal.core.ui.components.prev_profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun ContentPreview() {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(10.dp)
    ) {
        CurrentTitle()
        CurrentContent()
    }
}

@Composable
private fun CurrentTitle() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = "Este será un tipo de ejeplo de título"

        )
    }

}

@Composable
private fun CurrentContent() {

}