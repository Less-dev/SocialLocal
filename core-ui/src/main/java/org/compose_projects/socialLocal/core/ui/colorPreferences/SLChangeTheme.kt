package org.compose_projects.socialLocal.core.ui.colorPreferences

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialLocal.core.data.common.states.SLPreferencesState
import org.compose_projects.socialLocal.core.data.common.themes
import org.compose_projects.socialLocal.core.data.common.viewModels.SLPreferencesViewModel

@Composable
fun SLChangeTheme(slPreferencesViewModel: SLPreferencesViewModel = hiltViewModel()) {
    val state = slPreferencesViewModel.preferencesState.collectAsState().value

    when (state) {
        is SLPreferencesState.Loading -> {
            //loading
        }

        is SLPreferencesState.Error -> {
            SLColor.value = SLThemesList.default
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


