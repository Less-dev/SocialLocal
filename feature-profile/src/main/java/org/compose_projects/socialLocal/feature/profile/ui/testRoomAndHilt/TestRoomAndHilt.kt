package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialLocal.core.data.data.ChatProvider
import org.compose_projects.socialLocal.core.data.data.DataChatProvider
import org.compose_projects.socialLocal.core.data.data.MultimediaProvider
import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.core.data.data.UserProvider
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.ChatState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.DataChatState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.MultimediaState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.ProfileState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.UserState


@Composable
fun TestRoomAndHilt(testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel()) {
    //states
    val chatState = testRoomAndHiltViewModel.chatState.collectAsState().value
    val profileState = testRoomAndHiltViewModel.profileState.collectAsState().value
    val userState = testRoomAndHiltViewModel.userState.collectAsState().value
    val dataChatState = testRoomAndHiltViewModel.dataChatState.collectAsState().value
    val multimediaState = testRoomAndHiltViewModel.multimediaState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(onClick = {
            testRoomAndHiltViewModel.insertChat(
                MultimediaProvider(
                    pathImage = "/Documents/Media/ChatGlobal/images/image1.png",
                    pathVideo = "/Documents/Media/ChatGlobal/videos/video.mp4",
                    pathAudio = "/Documents/Media/ChatGlobal/audios/audio.mp3",
                    pathDocument = "/Documents/Media/ChatGlobal/documents/document.dock",
                    message = "Hi world, i am Less and this is a test de room and databases"
                )
            )
        }) {
            Text(text = "Insert Data")
        }

        Button(onClick = {
            testRoomAndHiltViewModel.deleteChat(
                ChatProvider(
                    chatID = 0,
                    isChatGlobal = false
                )
            )
        }) {
            Text(text = "Delete Data")
        }

        HorizontalDivider()

        when (chatState) {
            is ChatState.Loading -> {
                // Show a loading indicator
                CircularProgressIndicator()
            }

            is ChatState.Error -> {
                // Show an error message
                val error = (chatState as ChatState.Error).throwable
                Text(text = "Error: ${error.message}")
            }

            is ChatState.Success -> {
                // Show the list of ChatProviders
                val chatProviders = (chatState as ChatState.Success).data
                ChatProviderList(chatProviders)
            }
        }

        HorizontalDivider()

        when (profileState) {
            is ProfileState.Loading -> {
                // Show a loading indicator
                CircularProgressIndicator()
            }

            is ProfileState.Error -> {
                // Show an error message
                val error = (profileState as ProfileState.Error).throwable
                Text(text = "Error: ${error.message}")
            }

            is ProfileState.Success -> {
                // Show the list of ChatProviders
                val chatProviders = (profileState as ProfileState.Success).data
                ProfileProviderList(chatProviders)
            }
        }

        HorizontalDivider()


        when (userState) {
            is UserState.Loading -> {
                // Show a loading indicator
                CircularProgressIndicator()
            }

            is UserState.Error -> {
                // Show an error message
                val error = (userState as UserState.Error).throwable
                Text(text = "Error: ${error.message}")
            }

            is UserState.Success -> {
                // Show the list of ChatProviders
                val chatProviders = (userState as UserState.Success).data
                UserProviderList(chatProviders)
            }
        }

        HorizontalDivider()

        when (dataChatState) {
            is DataChatState.Loading -> {
                // Show a loading indicator
                CircularProgressIndicator()
            }

            is DataChatState.Error -> {
                // Show an error message
                val error = (dataChatState as DataChatState.Error).throwable
                Text(text = "Error: ${error.message}")
            }

            is DataChatState.Success -> {
                // Show the list of ChatProviders
                val chatProviders = (dataChatState as DataChatState.Success).data
                DataChatProviderList(chatProviders)
            }
        }

        HorizontalDivider()

        when (multimediaState) {
            is MultimediaState.Loading -> {
                // Show a loading indicator
                CircularProgressIndicator()
            }

            is MultimediaState.Error -> {
                // Show an error message
                val error = (multimediaState as MultimediaState.Error).throwable
                Text(text = "Error: ${error.message}")
            }

            is MultimediaState.Success -> {
                // Show the list of ChatProviders
                val chatProviders = (multimediaState as MultimediaState.Success).data
                MultimediaProviderList(chatProviders)
            }
        }
    }
}


@Composable
fun ChatProviderList(chatProviders: List<ChatProvider>) {
    LazyColumn {
        items(chatProviders) { chatProvider ->
            ChatProviderItem(chatProvider)
        }
    }
}

@Composable
fun ProfileProviderList(chatProviders: List<ProfileProvider>) {
    LazyColumn {
        items(chatProviders) { chatProvider ->
            ProfileProviderItem(chatProvider)
        }
    }
}

@Composable
fun UserProviderList(chatProviders: List<UserProvider>) {
    LazyColumn {
        items(chatProviders) { chatProvider ->
            UserProviderItem(chatProvider)
        }
    }
}

@Composable
fun DataChatProviderList(chatProviders: List<DataChatProvider>) {
    LazyColumn {
        items(chatProviders) { chatProvider ->
            DataChatProviderItem(chatProvider)
        }
    }
}


@Composable
fun MultimediaProviderList(chatProviders: List<MultimediaProvider>) {
    LazyColumn {
        items(chatProviders) { chatProvider ->
            MultimediaProviderItem(chatProvider)
        }
    }
}


@Composable
fun ChatProviderItem(chatProvider: ChatProvider) {
    // Customize the item UI as needed
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Text(text = chatProvider.chatID.toString(), modifier = Modifier.align(Alignment.TopCenter))
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Row {
                Text(text = chatProvider.isChatGlobal.toString())
                Text(text = chatProvider.profileID.toString())
            }
        }
    }
}

@Composable
fun ProfileProviderItem(chatProvider: ProfileProvider) {
    // Customize the item UI as needed
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Text(
            text = chatProvider.profileID.toString(),
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Row {
                Text(text = chatProvider.pathImageProfile)
                Text(text = chatProvider.description ?: "")
                Text(text = chatProvider.userID.toString())
            }
        }
    }
}

@Composable
fun UserProviderItem(chatProvider: UserProvider) {
    // Customize the item UI as needed
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Text(text = chatProvider.userID.toString(), modifier = Modifier.align(Alignment.TopCenter))
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Row {
                Text(text = chatProvider.iAm.toString())
                Text(text = chatProvider.isFriend.toString())
                Text(text = chatProvider.dataChatID.toString())
            }
        }
    }
}

@Composable
fun DataChatProviderItem(chatProvider: DataChatProvider) {
    // Customize the item UI as needed
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Text(
            text = chatProvider.dataChatID.toString(),
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Row {
                Text(text = chatProvider.dataChatID.toString())
                Text(text = chatProvider.iSend.toString())
                Text(text = chatProvider.contentType)
                Text(text = chatProvider.multimediaID.toString())

            }
        }
    }
}

@Composable
fun MultimediaProviderItem(chatProvider: MultimediaProvider) {
    // Customize the item UI as needed
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Text(
            text = chatProvider.multimediaID.toString(),
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(text = chatProvider.pathImage)
            Text(text = chatProvider.pathVideo)
            Text(text = chatProvider.pathDocument)
            Text(text = chatProvider.pathAudio)
        }
    }
}

