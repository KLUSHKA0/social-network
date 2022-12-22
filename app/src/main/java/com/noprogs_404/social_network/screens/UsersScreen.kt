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
                    viewModel.userList[us.id] = us
                }
            }) {
                Text("Add user", fontSize = 20.sp)
            }

            Button(onClick = {
                viewModel.db.deleteLastUser(viewModel.userList.toSortedMap().lastKey())
                viewModel.userList.remove(viewModel.userList.toSortedMap().lastKey())
            }) {
                Text("Delete last user", fontSize = 20.sp)
            }

        }
        LazyColumn {
            items(viewModel.userList.map { it }) { u ->
                userFrameView(user = u.value)
            }
        }

    }
}