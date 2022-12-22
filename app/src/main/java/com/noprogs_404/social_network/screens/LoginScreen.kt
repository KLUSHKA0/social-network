package com.noprogs_404.social_network.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.noprogs_404.social_network.ScreenObjects
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.utils.user


@Composable
fun LoginScreen(navController: NavController, viewModel: MainViewModel) {

    var id by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var log by remember {
        mutableStateOf("")
    }


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Login", fontSize = 26.sp)
            OutlinedTextField(
                value = id,
                onValueChange = { nV -> id = nV },
                label = { Text(text = "Enter user id") }
            )
            Button(onClick = {
                if (viewModel.userList[id.text.toInt()] != null) {
                    user = viewModel.userList[id.text.toInt()]!!
                    navController.navigate(ScreenObjects.ChatList.route)
                } else {
                    log = "Пользователя с айди ${id.text} не существует"
                }
            }) {
                Text(text = "Login")
            }
            Button(onClick = {
                navController.navigate(ScreenObjects.Main.route)
            }) {
                Text(text = "Admin panel")
            }
            Text(text = log)
        }
    }
}