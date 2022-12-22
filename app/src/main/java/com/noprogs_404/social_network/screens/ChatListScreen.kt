package com.noprogs_404.social_network.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.utils.Constants
import com.noprogs_404.social_network.utils.chatFragmnet
import com.noprogs_404.social_network.utils.chatFrameView
import com.noprogs_404.social_network.utils.user
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatListScreen(navController: NavController, viewModel: MainViewModel) {


    val chats = viewModel.chatList.filter { (k, v) -> v.username == user.username }

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Text(text = "User")
            Text(text = "Admin Panel")
        }
    ) {
        Column() {
            TopAppBar(
            ) {


                IconButton(onClick = {
                    scope.launch {
                        if (scaffoldState.drawerState.isClosed)
                            scaffoldState.drawerState.open()
                        else
                            scaffoldState.drawerState.close()
                    }
                }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Меню")
                }

                Text(Constants.APP_NAME, fontSize = 22.sp)
            }

            Box(modifier = Modifier.fillMaxSize()) {
//                Text(text = "test")
                LazyColumn() {
                    items(chats.map { it }) { chat ->
                        chatFragmnet(chat = chat.value)
                    }
                }
            }


        }
    }
}
