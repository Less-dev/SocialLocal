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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.Bubbles
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message1
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message10
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message11
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message12
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message2
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message3
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message4
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message5
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message6
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message7
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message8
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages.message9
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages_example
import org.compose_projects.socialLocal.core.ui.components.videoPlayer.VideoScreen


@Composable
fun InboxScreen() {
    VideoScreen(state = true, onDismissRequest = { /*TODO*/ } )

}



