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

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.compose_projects.socialLocal.R
import org.compose_projects.socialLocal.feature.auth.ui.AuthScreen
import org.compose_projects.socialLocal.feature.home.ui.HomeScreen
import org.compose_projects.socialLocal.feature.inbox.ui.InboxScreen
import org.compose_projects.socialLocal.feature.profile.ui.ProfileScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.auth) {

        composable(Routes.auth) {
            AuthScreen()
        }

        composable(Routes.globalChat) {
            HomeScreen()
        }

        composable(Routes.inbox) {
            InboxScreen()
        }

        composable(Routes.profile) {
            ProfileScreen()
        }

        // TODO: Add more destinations
    }
}


sealed class Screens(
    val route: String,
    val icon: Int,
    val index: Int
){
    data object global_chat: Screens(
        route = Routes.globalChat,
        icon = R.drawable.home_ic,
        index = 0
    )
    data object inbox: Screens(
        route = Routes.inbox,
        icon = R.drawable.inbox_ic,
        index = 0
    )

    data object profile: Screens(
        route = Routes.globalChat,
        icon = R.drawable.profile_ic,
        index = 0
    )
}