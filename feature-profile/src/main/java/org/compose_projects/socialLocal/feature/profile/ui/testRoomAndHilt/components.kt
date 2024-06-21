package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialLocal.core.data.data.ChatProvider
import org.compose_projects.socialLocal.core.data.data.DataChatProvider
import org.compose_projects.socialLocal.core.data.data.MultimediaProvider
import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.core.data.data.UserProvider

@Composable
internal fun Liner(content: @Composable () -> Unit) {
    HorizontalDivider(color = Color.Red)
    content()
    HorizontalDivider(color = Color.Red)
}


@Composable
fun CampousItems(contentItem: @Composable () -> Unit, editContent: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .align(Alignment.CenterStart)
        ) {
            contentItem()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .align(Alignment.CenterEnd)
        ) {
            editContent()
        }
    }
}


@Composable
internal fun Add(
    title: String
) {

    var state by remember { mutableStateOf(false) }
    Button(onClick = { state = true }) {
        Text(text = "Add item of $title")
    }

    DialogAdd(title = title, state = state, onDissmissRequest = { state = false })

}

@Composable
private fun DialogAdd(
    title: String,
    state: Boolean,
    onDissmissRequest: () -> Unit,

    ) {
    if (state) {
        Dialog(
            onDismissRequest = { onDissmissRequest() },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                ContentAdd(entity = title)
            }
        }
    }
}


@Composable
private fun ContentAdd(
    entity: String,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel()
) {
    val chatEntity = "Chat Entity"
    val profileEntity = "Profile Entity"
    val userEntity = "User Entity"
    val dataChatEntity = "Data Chat Entity"
    val multimediaEntity = "Multimedia Entity"

    val modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)

    when (entity) {
        chatEntity -> {

            var isChatGlobal by remember { mutableStateOf("true") }

            Column {
                TextField(
                    value = isChatGlobal,
                    onValueChange = { isChatGlobal = it },
                    modifier = modifier
                )

                Button(onClick = {
                    testRoomAndHiltViewModel.insertChat(
                        ChatProvider(
                            isChatGlobal = if (isChatGlobal == "true") true else false
                        )
                    )
                }) {
                    Text(text = "Add items for $entity")
                }
            }

        }

        profileEntity -> {

            var pathImageProfile by remember { mutableStateOf("") }
            var description by remember { mutableStateOf("") }

            Column {
                TextField(
                    value = pathImageProfile,
                    onValueChange = { pathImageProfile = it },
                    modifier = modifier
                )
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    modifier = modifier
                )

                Button(onClick = {
                    testRoomAndHiltViewModel.insertProfile(
                        ProfileProvider(
                            pathImageProfile = pathImageProfile,
                            description = description
                        )
                    )
                }) {
                    Text(text = "Add items for $entity")
                }
            }
        }

        userEntity -> {
            var iAm by remember { mutableStateOf("true") }
            var isFriend by remember { mutableStateOf("true") }
            Column {
                TextField(
                    value = iAm,
                    onValueChange = { iAm = it },
                    modifier = modifier
                )
                TextField(
                    value = isFriend,
                    onValueChange = { isFriend = it },
                    modifier = modifier
                )
                Button(onClick = {
                    testRoomAndHiltViewModel.insertUser(
                        UserProvider(
                            iAm = if (iAm == "true") true else false,
                            isFriend = if (isFriend == "true") true else false
                        )
                    )
                }) {
                    Text(text = "Add items for $entity")
                }
            }
        }

        dataChatEntity -> {

            var dateTime by remember { mutableStateOf("") }
            var iSend by remember { mutableStateOf("true") }
            var contentType by remember { mutableStateOf("") }

            Column {
                TextField(
                    value = dateTime,
                    onValueChange = { dateTime = it },
                    modifier = modifier
                )
                TextField(
                    value = iSend,
                    onValueChange = { iSend = it },
                    modifier = modifier
                )
                TextField(
                    value = contentType,
                    onValueChange = { contentType = it },
                    modifier = modifier
                )

                Button(onClick = {
                    testRoomAndHiltViewModel.insertDataChat(
                        DataChatProvider(
                            dateTime = dateTime,
                            iSend = if (iSend == "true") true else false,
                            contentType = contentType
                        )
                    )
                }) {
                    Text(text = "Add items for $entity")
                }

            }
        }

        multimediaEntity -> {

            var pathImage by remember { mutableStateOf("") }
            var pathVideo by remember { mutableStateOf("") }
            var pathDocument by remember { mutableStateOf("") }
            var pathAudio by remember { mutableStateOf("") }
            var message by remember { mutableStateOf("") }

            Column {
                TextField(
                    value = pathImage,
                    onValueChange = { pathImage = it },
                    modifier = modifier
                )
                TextField(
                    value = pathVideo,
                    onValueChange = { pathVideo = it },
                    modifier = modifier
                )
                TextField(
                    value = pathDocument,
                    onValueChange = { pathDocument = it },
                    modifier = modifier
                )
                TextField(
                    value = pathAudio,
                    onValueChange = { pathAudio = it },
                    modifier = modifier
                )
                TextField(
                    value = message,
                    onValueChange = { message = it },
                    modifier = modifier
                )
                Button(onClick = {
                    testRoomAndHiltViewModel.insertMultimedia(
                        MultimediaProvider(
                            pathImage = pathImage,
                            pathVideo = pathVideo,
                            pathDocument = pathDocument,
                            pathAudio = pathAudio,
                            message = message
                        )
                    )
                }) {
                    Text(text = "Add items for $entity")
                }
            }
        }
    }
}


internal data class providers(
    val chatProvider: ChatProvider? = null,
    val profileProvider: ProfileProvider? = null,
    val userProvider: UserProvider? = null,
    val dataChatProvider: DataChatProvider? = null,
    val multimediaProvider: MultimediaProvider? = null
)

@Composable
internal fun DialogDelete(
    state: Boolean,
    title: String,
    providers: providers,
    onDissmissRequest: () -> Unit,

    ) {
    if (state) {

        val chatEntity = "Chat Entity"
        val profileEntity = "Profile Entity"
        val userEntity = "User Entity"
        val dataChatEntity = "Data Chat Entity"
        val multimediaEntity = "Multimedia Entity"
        if (providers.chatProvider != null) {
            DialogSL(onDissmissRequest = { onDissmissRequest() }) {
                ContentDeleteChat(
                    chatProvider = providers.chatProvider,
                    entity = title,
                    onDissmissRequest = { onDissmissRequest() })
            }

        } else if (providers.profileProvider != null) {
            DialogSL(onDissmissRequest = { onDissmissRequest() }) {

            }
        } else if (providers.userProvider != null) {
            DialogSL(onDissmissRequest = { onDissmissRequest() }) {

            }
        } else if (providers.dataChatProvider != null) {
            DialogSL(onDissmissRequest = { onDissmissRequest() }) {

            }
        } else if (providers.multimediaProvider != null) {
            DialogSL(onDissmissRequest = { onDissmissRequest() }) {

            }
        }
    }
}


@Composable
private fun DialogSL(onDissmissRequest: () -> Unit, content: @Composable () -> Unit) {
    Dialog(
        onDismissRequest = { onDissmissRequest() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}


@Composable
private fun ContentDeleteChat(
    chatProvider: ChatProvider,
    entity: String,
    onDissmissRequest: () -> Unit,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel()
) {


    val modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)


    var idItem by remember { mutableIntStateOf(0) }
    var showDialogEditItem by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Button(onClick = {
                showDialogEditItem = true
            }) {
                Text(text = "Edit item")
            }

            Button(onClick = {
                testRoomAndHiltViewModel.deleteChat(
                    chatProvider
                )
                onDissmissRequest()
            }) {
                Text(text = "Delete item ${chatProvider.chatID}")
            }
        }
    }

    DialogEditItem(
        state = showDialogEditItem,
        onDissmissRequest = { showDialogEditItem = false }) {
        ContentEditItemForChat(chatProvider = chatProvider) {
            onDissmissRequest()
        }
    }
}


@Composable
private fun ContentDeleteProfile(
    chatProvider: ChatProvider,
    entity: String,
    onDissmissRequest: () -> Unit,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel()
) {


    val modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)


    var idItem by remember { mutableIntStateOf(0) }
    var showDialogEditItem by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Button(onClick = {
                showDialogEditItem = true
            }) {
                Text(text = "Edit item")
            }

            Button(onClick = {
                testRoomAndHiltViewModel.deleteChat(
                    chatProvider
                )
                onDissmissRequest()
            }) {
                Text(text = "Delete item ${chatProvider.chatID}")
            }
        }
    }

    DialogEditItem(
        state = showDialogEditItem,
        onDissmissRequest = { showDialogEditItem = false }) {
        ContentEditItemForChat(chatProvider = chatProvider) {
            onDissmissRequest()
        }
    }
}



@Composable
private fun ContentDeleteUser(
    chatProvider: ChatProvider,
    entity: String,
    onDissmissRequest: () -> Unit,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel()
) {


    val modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)


    var idItem by remember { mutableIntStateOf(0) }
    var showDialogEditItem by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Button(onClick = {
                showDialogEditItem = true
            }) {
                Text(text = "Edit item")
            }

            Button(onClick = {
                testRoomAndHiltViewModel.deleteChat(
                    chatProvider
                )
                onDissmissRequest()
            }) {
                Text(text = "Delete item ${chatProvider.chatID}")
            }
        }
    }

    DialogEditItem(
        state = showDialogEditItem,
        onDissmissRequest = { showDialogEditItem = false }) {
        ContentEditItemForChat(chatProvider = chatProvider) {
            onDissmissRequest()
        }
    }
}



@Composable
private fun ContentDeleteDataChat(
    chatProvider: ChatProvider,
    entity: String,
    onDissmissRequest: () -> Unit,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel()
) {


    val modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)


    var idItem by remember { mutableIntStateOf(0) }
    var showDialogEditItem by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Button(onClick = {
                showDialogEditItem = true
            }) {
                Text(text = "Edit item")
            }

            Button(onClick = {
                testRoomAndHiltViewModel.deleteChat(
                    chatProvider
                )
                onDissmissRequest()
            }) {
                Text(text = "Delete item ${chatProvider.chatID}")
            }
        }
    }

    DialogEditItem(
        state = showDialogEditItem,
        onDissmissRequest = { showDialogEditItem = false }) {
        ContentEditItemForChat(chatProvider = chatProvider) {
            onDissmissRequest()
        }
    }
}



@Composable
private fun ContentDeleteMultimedia(
    chatProvider: ChatProvider,
    entity: String,
    onDissmissRequest: () -> Unit,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel()
) {


    val modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)


    var idItem by remember { mutableIntStateOf(0) }
    var showDialogEditItem by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Button(onClick = {
                showDialogEditItem = true
            }) {
                Text(text = "Edit item")
            }

            Button(onClick = {
                testRoomAndHiltViewModel.deleteChat(
                    chatProvider
                )
                onDissmissRequest()
            }) {
                Text(text = "Delete item ${chatProvider.chatID}")
            }
        }
    }

    DialogEditItem(
        state = showDialogEditItem,
        onDissmissRequest = { showDialogEditItem = false }) {
        ContentEditItemForChat(chatProvider = chatProvider) {
            onDissmissRequest()
        }
    }
}



@Composable
private fun DialogEditItem(
    state: Boolean,
    onDissmissRequest: () -> Unit,
    content: @Composable () -> Unit
) {
    if (state) {
        Dialog(
            onDismissRequest = { onDissmissRequest() }, properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            content()
        }
    }
}

@Composable
private fun ContentEditItemForChat(
    chatProvider: ChatProvider,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel(),
    onDissmissRequest: () -> Unit
) {
    var chatID by remember { mutableStateOf(chatProvider.chatID.toString()) }
    var isChatGlobal by remember { mutableStateOf(chatProvider.isChatGlobal.toString()) }
    var profileID by remember { mutableStateOf(chatProvider.profileID.toString()) }


    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = chatID,
            onValueChange = { chatID = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        TextField(
            value = isChatGlobal,
            onValueChange = { isChatGlobal = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        TextField(
            value = profileID,
            onValueChange = { profileID = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        Button(onClick = {
            testRoomAndHiltViewModel.updateChat(
                ChatProvider(
                    chatID = chatID.toInt(),
                    isChatGlobal = if (isChatGlobal == "true") true else false,
                    profileID = profileID.toInt()
                )
            )
            onDissmissRequest()
        }) {
            Text(text = "Save changes")
        }
    }
}


@Composable
private fun ContentEditItemForProfile(
    chatProvider: ChatProvider,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel(),
    onDissmissRequest: () -> Unit
) {
    var chatID by remember { mutableStateOf(chatProvider.chatID.toString()) }
    var isChatGlobal by remember { mutableStateOf(chatProvider.isChatGlobal.toString()) }
    var profileID by remember { mutableStateOf(chatProvider.profileID.toString()) }


    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = chatID,
            onValueChange = { chatID = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        TextField(
            value = isChatGlobal,
            onValueChange = { isChatGlobal = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        TextField(
            value = profileID,
            onValueChange = { profileID = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        Button(onClick = {
            testRoomAndHiltViewModel.updateChat(
                ChatProvider(
                    chatID = chatID.toInt(),
                    isChatGlobal = if (isChatGlobal == "true") true else false,
                    profileID = profileID.toInt()
                )
            )
            onDissmissRequest()
        }) {
            Text(text = "Save changes")
        }
    }
}


@Composable
private fun ContentEditItemForUser(
    chatProvider: ChatProvider,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel(),
    onDissmissRequest: () -> Unit
) {
    var chatID by remember { mutableStateOf(chatProvider.chatID.toString()) }
    var isChatGlobal by remember { mutableStateOf(chatProvider.isChatGlobal.toString()) }
    var profileID by remember { mutableStateOf(chatProvider.profileID.toString()) }


    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = chatID,
            onValueChange = { chatID = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        TextField(
            value = isChatGlobal,
            onValueChange = { isChatGlobal = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        TextField(
            value = profileID,
            onValueChange = { profileID = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        Button(onClick = {
            testRoomAndHiltViewModel.updateChat(
                ChatProvider(
                    chatID = chatID.toInt(),
                    isChatGlobal = if (isChatGlobal == "true") true else false,
                    profileID = profileID.toInt()
                )
            )
            onDissmissRequest()
        }) {
            Text(text = "Save changes")
        }
    }
}


@Composable
private fun ContentEditItemForDataChat(
    chatProvider: ChatProvider,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel(),
    onDissmissRequest: () -> Unit
) {
    var chatID by remember { mutableStateOf(chatProvider.chatID.toString()) }
    var isChatGlobal by remember { mutableStateOf(chatProvider.isChatGlobal.toString()) }
    var profileID by remember { mutableStateOf(chatProvider.profileID.toString()) }


    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = chatID,
            onValueChange = { chatID = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        TextField(
            value = isChatGlobal,
            onValueChange = { isChatGlobal = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        TextField(
            value = profileID,
            onValueChange = { profileID = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        Button(onClick = {
            testRoomAndHiltViewModel.updateChat(
                ChatProvider(
                    chatID = chatID.toInt(),
                    isChatGlobal = if (isChatGlobal == "true") true else false,
                    profileID = profileID.toInt()
                )
            )
            onDissmissRequest()
        }) {
            Text(text = "Save changes")
        }
    }
}


@Composable
private fun ContentEditItemForMultimedia(
    chatProvider: ChatProvider,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel(),
    onDissmissRequest: () -> Unit
) {
    var chatID by remember { mutableStateOf(chatProvider.chatID.toString()) }
    var isChatGlobal by remember { mutableStateOf(chatProvider.isChatGlobal.toString()) }
    var profileID by remember { mutableStateOf(chatProvider.profileID.toString()) }


    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = chatID,
            onValueChange = { chatID = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        TextField(
            value = isChatGlobal,
            onValueChange = { isChatGlobal = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        TextField(
            value = profileID,
            onValueChange = { profileID = it },
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(50.dp)
        )

        Button(onClick = {
            testRoomAndHiltViewModel.updateChat(
                ChatProvider(
                    chatID = chatID.toInt(),
                    isChatGlobal = if (isChatGlobal == "true") true else false,
                    profileID = profileID.toInt()
                )
            )
            onDissmissRequest()
        }) {
            Text(text = "Save changes")
        }
    }
}



