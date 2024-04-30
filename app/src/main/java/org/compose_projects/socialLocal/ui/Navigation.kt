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

package org.compose_projects.socialLocal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.compose_projects.socialLocal.R
import org.compose_projects.socialLocal.core.ui.SLColor
import org.compose_projects.socialLocal.feature.auth.ui.AuthScreen
import org.compose_projects.socialLocal.feature.home.ui.HomeScreen
import org.compose_projects.socialLocal.feature.inbox.ui.InboxScreen
import org.compose_projects.socialLocal.feature.profile.ui.ProfileScreen
import org.compose_projects.socialLocal.CONSTANTS.titleAuth
import org.compose_projects.socialLocal.CONSTANTS.titleHome
import org.compose_projects.socialLocal.CONSTANTS.titleInbox
import org.compose_projects.socialLocal.CONSTANTS.titleProfile
import org.compose_projects.socialLocal.ui.Screens.Companion.screens


@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    var titleTopAppBar by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBarNavigation(title = titleTopAppBar) },
        bottomBar = { BottomAppNavigation(navController = navController, view = titleTopAppBar) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = SLColor.BackgroundColor
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

                NavHost(navController = navController, startDestination = Routes.auth) {

                    composable(Routes.auth) {
                        titleTopAppBar = titleAuth
                        AuthScreen()
                    }

                    composable(Routes.globalChat) {
                        titleTopAppBar = titleHome
                        HomeScreen()
                    }

                    composable(Routes.inbox) {
                        titleTopAppBar = titleInbox
                        InboxScreen()
                    }

                    composable(Routes.profile) {
                        titleTopAppBar = titleProfile
                        ProfileScreen()
                    }

                    // TODO: Add more destinations
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarNavigation(title: String) {
    TopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = SLColor.BackgroundTopAppBarColor,
            titleContentColor = SLColor.TextTopAppBarColor
        )
    )
}


@Composable
private fun BottomAppNavigation(navController: NavHostController, view: String) {

    BottomAppBar(
        modifier = Modifier.height(120.dp)
            .systemBarsPadding()
        ,
        containerColor = SLColor.BackgroundBottomAppBarColor,

    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            items(screens) { screen ->
                val backgroundIcon =
                    if (view == screen.title) SLColor.BackgroundIconButtonAppBarColor else SLColor.BackgroundTopAppBarColor

                IconButton(
                    onClick = {
                        navController.navigate(screen.route)
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        backgroundIcon
                    )
                ) {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        tint = if (view == screen.title) SLColor.IconSelectedBottomAppBarColor else SLColor.IconUnSelectedBottomAppBarColor,
                        modifier = Modifier.size(25.dp)
                    )
                }

            }
        }
    }
}


private sealed class Screens(
    val route: String,
    val icon: Int,
    val title: String,
    val index: Int
) {
    data object global_chat : Screens(
        route = Routes.globalChat,
        icon = R.drawable.home_ic,
        title = titleHome,
        index = 0
    )

    data object inbox : Screens(
        route = Routes.inbox,
        icon = R.drawable.inbox_ic,
        title = titleInbox,
        index = 0
    )

    data object profile : Screens(
        route = Routes.profile,
        icon = R.drawable.profile_ic,
        title = titleProfile,
        index = 0
    )

    companion object {
        val screens = listOf(global_chat, inbox, profile)
    }
}