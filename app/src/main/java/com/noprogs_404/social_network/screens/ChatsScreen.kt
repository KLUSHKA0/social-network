package com.noprogs_404.social_network.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.noprogs_404.social_network.ScreenObjects
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.utils.chatFrameView
import com.noprogs_404.social_network.utils.mainView
import java.util.TreeMap

@Composable
fun ChatsScreen(navController: NavController, viewModel: MainViewModel) {

    viewModel.chatList = TreeMap(viewModel.chatList)

    Column {
        Row {
            Button(onClick = {
                navController.navigate(ScreenObjects.AddChat.route)
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
                navController.navigate(ScreenObjects.DeleteChat.route)
//                viewModel.db.deleteLastUser(viewModel.userList.last().id)
//                viewModel.userList.removeAt(viewModel.userList.size - 1)
            }) {
                Text("Delete chat", fontSize = 20.sp)
            }




        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(viewModel.chatList.map { it }) { c ->
                mainView(chat = c.value)
            }
        }

    }
}