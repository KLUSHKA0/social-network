package com.noprogs_404.social_network.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.noprogs_404.social_network.Screans
import com.noprogs_404.social_network.repo.MainViewModel


@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.navigate(Screans.Users.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Users", fontSize = 20.sp)
        }
        Button(
            onClick = { navController.navigate(Screans.Chats.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Chats", fontSize = 20.sp)
        }
        Button(
            onClick = {
                navController.navigate(Screans.ChatPermissions.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Chat permissions", fontSize = 20.sp)
        }
        Button(
            onClick = { navController.navigate(Screans.Messages.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Messages", fontSize = 20.sp)
        }

    }
}