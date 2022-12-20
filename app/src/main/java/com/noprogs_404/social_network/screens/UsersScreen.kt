package com.noprogs_404.social_network.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import com.noprogs_404.social_network.ScreenObjects
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.utils.userFrameView




@Composable
fun UsersScreen(navController: NavController, viewModel: MainViewModel) {

    Column {
        Row {
            Button(onClick = { navController.navigate(ScreenObjects.AddUser.route) }) {
                Text(text = "Add User", fontSize = 20.sp)
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
            }
        }

    }
}