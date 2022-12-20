package com.noprogs_404.social_network.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.noprogs_404.social_network.models.Chat
import com.noprogs_404.social_network.models.User
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.utils.chatFrameView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun ChatsScreen(navController: NavController, viewModel: MainViewModel) {


    Column {
        Row {
            Button(onClick = {
//                viewModel.lastUserId += 1
//
//                GlobalScope.launch {
//
//                    val us = Chat(
//                        id = viewModel.lastUserId,
//                        is_bot = false,
//                        name = "name",
//                        surname = "surname",
//                        username = "username",
//                        language_code = "ru",
//                        is_premium = true
//                    )
//                    viewModel.db.addUser(us)
//                    viewModel.userList.add(us)
//                }
            }) {
                Text("Add chat", fontSize = 20.sp)
            }

            Button(onClick = {
//                viewModel.db.deleteLastUser(viewModel.userList.last().id)
//                viewModel.userList.removeAt(viewModel.userList.size - 1)
            }) {
                Text("Delete last chat", fontSize = 20.sp)
            }




        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(viewModel.chatList) { c ->
            chatFrameView(chat = c)
//                Column {
//                    Text(text = "id: ${u.id}")
//                    Text(text = "type: ${u.type}")
//                    Text(text = "title: ${u.title}")
//                    Text(text = "first_name: ${u.first_name}")
//                    Text(text = "last_name: ${u.last_name}")
//                    Text(text = "username: ${u.username}")
//                    Text(text = "photo_id: ${u.photo_id}")
//                }
            }
        }

    }
}