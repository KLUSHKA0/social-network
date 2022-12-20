package com.noprogs_404.social_network.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.noprogs_404.social_network.models.User
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.utils.userFrameView


@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition", "UnrememberedMutableState")
@Composable
fun UsersScreen(navController: NavController, viewModel: MainViewModel) {

    Column {
        Row {
            Button(onClick = {
                viewModel.lastUserId += 1

                GlobalScope.launch {

                    val us = User(
                        id = viewModel.lastUserId,
                        is_bot = false,
                        name = "name",
                        surname = "surname",
                        username = "username",
                        language_code = "ru",
                        is_premium = true
                    )
                    viewModel.db.addUser(us)
                    viewModel.userList.add(us)
                }
            }) {
                Text("Add user", fontSize = 20.sp)
            }

            Button(onClick = {
                viewModel.db.deleteLastUser(viewModel.userList.last().id)
                viewModel.userList.removeAt(viewModel.userList.size - 1)
            }) {
                Text("Delete last user", fontSize = 20.sp)
            }

        }
        LazyColumn {
            items(viewModel.userList) { u ->
                userFrameView(user = u)
//                Column {
//                    Text(text = "id: ${u.id}")
//                    Text(text = "name: ${u.name}")
//                    Text(text = "bot?: ${u.is_bot}")
//                    Text(text = "surname: ${u.surname}")
//                    Text(text = "username: ${u.username}")
//                    Text(text = "language: ${u.language_code}")
//                    Text(text = "premium: ${u.is_premium}")
//                }
            }
        }

    }
}