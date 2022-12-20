package com.noprogs_404.social_network.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.noprogs_404.social_network.ScreenObjects
import com.noprogs_404.social_network.models.User
import com.noprogs_404.social_network.repo.MainViewModel

@Composable
fun AddUserScreen(navController: NavController, viewModel: MainViewModel) {


    var is_bot by remember {
        mutableStateOf(false)
    }
    var name by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var surname by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var language_code by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var is_premium by remember {
        mutableStateOf(false)
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Text(text = "Is_bot")
            Switch(checked = is_bot, onCheckedChange = { is_bot = it })
            Text(text = "Name")
            OutlinedTextField(value = name, onValueChange = { nV -> name = nV })
            Text(text = "Surname")
            OutlinedTextField(value = surname, onValueChange = { nV -> surname = nV })
            Text(text = "Username")
            OutlinedTextField(value = username, onValueChange = { nV -> username = nV })
            Text(text = "Lang_code")
            OutlinedTextField(value = language_code, onValueChange = { nV -> language_code = nV })
            Text(text = "Is_premium")
            Switch(checked = is_premium, onCheckedChange = { is_premium = it })

            Button(onClick = {
                viewModel.addUser(
                    User(
                        -1,
                        is_bot,
                        name.text,
                        surname.text,
                        username.text,
                        language_code.text,
                        is_premium
                    )
                )
                navController.navigate(ScreenObjects.Users.route)
            }) {
                Text(text = "Add")
            }
        }
    }
}