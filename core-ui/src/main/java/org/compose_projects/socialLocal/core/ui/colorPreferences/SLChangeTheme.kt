package org.compose_projects.socialLocal.core.ui.colorPreferences

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.compose_projects.socialLocal.core.data.common.states.SLPreferencesState
import org.compose_projects.socialLocal.core.data.common.themes
import org.compose_projects.socialLocal.core.data.common.viewModels.SLPreferencesViewModel
import org.compose_projects.socialLocal.core.data.data.SLPreferencesProvider

@Composable
fun SLChangeTheme(slPreferencesViewModel: SLPreferencesViewModel = hiltViewModel()) {
    val state = slPreferencesViewModel.preferencesState.collectAsState().value
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }

    when (state) {
        is SLPreferencesState.Loading -> {
            text = "Cargando"
        }

        is SLPreferencesState.Error -> {
            text = SLThemesList.black.toString()
        }

        is SLPreferencesState.Success -> {
            val data = (state as SLPreferencesState.Success).data
            data.map {
                when(it.theme) {
                    themes.DEFAULT -> SLColor.value = SLThemesList.default
                    themes.BLACK -> SLColor.value = SLThemesList.black
                    else -> SLColor.value = SLThemesList.default
                }
            }
        }
    }

}


@Composable
fun RevData(data: List<SLPreferencesProvider>) {
    data.map {
        when(it.theme) {
            themes.DEFAULT -> SLColor.value = SLThemesList.default
            themes.BLACK -> SLColor.value = SLThemesList.black
            else -> SLColor.value = SLThemesList.default
        }
    }
}