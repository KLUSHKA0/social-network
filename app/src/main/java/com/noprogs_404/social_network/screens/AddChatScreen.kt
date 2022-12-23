package com.noprogs_404.social_network.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.noprogs_404.social_network.ScreenObjects
import com.noprogs_404.social_network.models.Chat
import com.noprogs_404.social_network.models.User
import com.noprogs_404.social_network.repo.MainViewModel

@Composable
fun AddChatScreen(navController: NavController, viewModel: MainViewModel) {


    var type by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var title by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var first_name by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var last_name by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var is_forum by remember {
        mutableStateOf(false)
    }
    var photo_id by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var bio by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var description by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var pinned_message_id by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column {
            Text(text = "Type")
            OutlinedTextField(value = type, onValueChange = { nV -> type = nV })
            Text(text = "Title")
            OutlinedTextField(value = title, onValueChange = { nV -> title = nV })
            Text(text = "Username")
            OutlinedTextField(value = username, onValueChange = { nV -> username = nV })
            Text(text = "First name")
            OutlinedTextField(value = first_name, onValueChange = { nV -> first_name = nV })
            Text(text = "Last name")
            OutlinedTextField(value = last_name, onValueChange = { nV -> last_name = nV })
            Text(text = "Is forum")
            Switch(checked = is_forum, onCheckedChange = { is_forum = it })
            Text(text = "Photo id")
            OutlinedTextField(value = photo_id, onValueChange = { nV -> photo_id = nV })
            Text(text = "Bio")
            OutlinedTextField(value = bio, onValueChange = { nV -> bio = nV })
            Text(text = "Description")
            OutlinedTextField(value = description, onValueChange = { nV -> description = nV })
            Text(text = "Pinned message id")
            OutlinedTextField(value = pinned_message_id, onValueChange = { nV -> pinned_message_id = nV })

            Button(onClick = {
                viewModel.addChat(
                    Chat(
                        -1,
                        type.text,
                        title.text,
                        username.text,
                        first_name.text,
                        last_name.text,
                        is_forum,
                        photo_id.text.toInt(),
                        bio.text,
                        description.text,
                        pinned_message_id.text.toInt()
                    )
                )
                navController.navigate(ScreenObjects.Chats.route)
            }) {
                Text(text = "Add")
            }
        }
    }
}