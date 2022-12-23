package com.noprogs_404.social_network.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.noprogs_404.social_network.ScreenObjects
import com.noprogs_404.social_network.repo.MainViewModel

@Composable
fun DeleteChatScreen(navController: NavController, viewModel: MainViewModel) {

    var id by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column {
            Text(text = "Id chat")
            OutlinedTextField(value = id, onValueChange = { nV -> id = nV })
            Button(onClick = {
                viewModel.deleteChat(id.text.toInt())
                navController.navigate(ScreenObjects.Chats.route)
            }) {
                Text(text = "Delete")
            }
        }
    }
}