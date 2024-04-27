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

package org.compose_projects.socialLocal.feature.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.compose_projects.socialLocal.feature.home.ui.HomeUiState.Loading
import org.compose_projects.socialLocal.feature.home.ui.HomeUiState.Error
import org.compose_projects.socialLocal.feature.home.ui.HomeUiState.Success

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = hiltViewModel()) {
    val items by homeViewModel.uiState.collectAsStateWithLifecycle()
    if (items is Success) {
        HomeScreen(
            listItems = (items as Success).data,
            onSave = { name -> homeViewModel.addUsers(name) },
            modifier = modifier
        )
    }
}

@Composable
internal fun HomeScreen(
    listItems: List<String>,
    onSave: (name: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf("") }
    Column {
        OutlinedTextField(value = text, onValueChange = { text = it })
        LazyColumn {
            items(listItems){
                Text(text = it)
                HorizontalDivider()
            }
        }
    }

}