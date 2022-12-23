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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.noprogs_404.social_network.ScreenObjects
import com.noprogs_404.social_network.models.ChatPermission
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.utils.mainView

@Composable
fun ChatPermissionScreen(navController: NavController, viewModel: MainViewModel) {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(onClick = { navController.navigate(ScreenObjects.AddUser.route) }) {
                Text(text = "Add chatPermission", fontSize = 20.sp, textAlign = TextAlign.Center)
            }

            Button(onClick = { navController.navigate(ScreenObjects.DeleteUser.route) }) {
                Text(text = "Delete chatPermission", fontSize = 20.sp, textAlign = TextAlign.Center)
            }
        }
        LazyColumn {
            items(viewModel.chatPermissionList.map{ it }) { cP ->
                mainView(chatPermission = cP.value)
            }
        }

    }
}