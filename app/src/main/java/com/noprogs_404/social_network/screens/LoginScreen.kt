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
import com.noprogs_404.social_network.repo.MainViewModel


@Composable
fun LoginScreen(navController: NavController, viewModel: MainViewModel) {

    var login by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var password by remember {
        mutableStateOf(TextFieldValue(""))
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
                value = login,
                onValueChange = { nV -> login = nV },
                label = { Text(text = "Enter login") }
            )
            OutlinedTextField(
                value = password,
                onValueChange = { nV -> password = nV },
                label = { Text(text = "Enter password") }
            )
            Button(onClick = { }) {
                Text(text = "Login")
            }
        }
    }
}