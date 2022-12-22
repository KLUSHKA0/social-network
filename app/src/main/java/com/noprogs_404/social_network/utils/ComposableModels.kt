package com.noprogs_404.social_network.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noprogs_404.social_network.models.Chat
import com.noprogs_404.social_network.models.User


@Composable
fun chatFrameView(chat: Chat) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black)

    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
            Column {
                Text(text = "title: ${chat.title}")
                Text(text = "username: ${chat.username}")
                Text(text = "first_name: ${chat.first_name}")
                Text(text = "last_name: ${chat.last_name}")
                Text(text = "bio: ${chat.bio}")
                Text(text = "description: ${chat.description}")
            }
            Column(modifier = Modifier.padding(start = 20.dp)) {
                Text(text = "id: ${chat.id}")
                Text(text = "type: ${chat.type}")
                Text(text = "is_forum: ${chat.is_forum}")
                Text(text = "photo_id: ${chat.photo_id}")
                Text(text = "pinned_msg_id: ${chat.pinned_message_id}")
            }
        }
    }
}

@Composable
fun userFrameView(user: User) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
            Column(modifier = Modifier.padding(
            )) {
                Text(text = "name: ${user.name}")
                Text(text = "surname: ${user.surname}")
                Text(text = "username: ${user.username}")
                Text(text = "lang: ${user.language_code}")
            }
            Column(modifier = Modifier.padding(
                start = 20.dp
            )) {
                Text(text = "id: ${user.id}")
                Text(text = "is_bot: ${user.is_bot}")
                Text(text = "is_premium: ${user.is_premium}")
            }
        }
    }
}

@Composable
fun chatFragmnet(chat: Chat) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 5.dp,
                start = 5.dp,
                end = 5.dp
            )
            .border(1.dp, Color.Black, RoundedCornerShape(15.dp)),
//        shape = RoundedCornerShape(15.dp),
//        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp,
                    top = 6.dp,
                    bottom = 6.dp
                )
        ) {
            Text(text = chat.username, fontSize = 20.sp)
        }
    }
}