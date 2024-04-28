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

package org.compose_projects.socialLocal.feature.inbox.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.compose_projects.socialLocal.core.ui.SLColor


@Composable
fun InboxScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(SLColor.BackgroundColor),
        contentAlignment = Alignment.TopCenter,
    ) {
        (0..12).forEach {
            InboxScreen(it)
        }
    }

}

@Composable
internal fun InboxScreen(aa: Int) {
    LazyColumn {
        items(aa) {
            HorizontalDivider()
            Text(text = it.toString(), color = SLColor.TextsColor)
            HorizontalDivider()
        }
    }
}