package com.noprogs_404.social_network.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noprogs_404.social_network.models.Chat
import com.noprogs_404.social_network.models.ChatPermission
import com.noprogs_404.social_network.models.Message
import com.noprogs_404.social_network.models.User
import com.noprogs_404.social_network.ui.theme.SocialnetworkTheme


@Composable
fun mainView(
    user: User? = null,
    chat: Chat? = null,
    message: Message? = null,
    chatPermission: ChatPermission? = null
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 5.dp,
                start = 7.dp,
                end = 7.dp
            )
            .border(1.dp, Color.Black, RoundedCornerShape(15.dp))
    ) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 6.dp)

        ) {
            if (user != null) {
                userFrameView(user = user)
            }

            if (chat != null) {
                chatFrameView(chat = chat)
            }

            if (message != null) {
                messageFrameView(message = message)
            }

            if (chatPermission != null) {
                chatPermissionFrameView(chatPermission = chatPermission)
            }
        }
    }


}

@Composable
fun chatFrameView(chat: Chat) {
    Column {
        Text(text = "id: ${chat.id}")
        Text(text = "type: ${chat.type}")
        Text(text = "is_forum: ${chat.is_forum}")
        Text(text = "photo_id: ${chat.photo_id}")
        Text(text = "pinned_msg_id: ${chat.pinned_message_id}")
        Text(text = "title: ${chat.title}")
        Text(text = "username: ${chat.username}")
        Text(text = "first_name: ${chat.first_name}")
        Text(text = "last_name: ${chat.last_name}")
        Text(text = "bio: ${chat.bio}")
        Text(text = "description: ${chat.description}")
    }
}

@Composable
fun userFrameView(user: User) {

    Column {
        Text(text = "id: ${user.id}")
        Text(text = "is_bot: ${user.is_bot}")
        Text(text = "is_premium: ${user.is_premium}")
        Text(text = "name: ${user.name}")
        Text(text = "surname: ${user.surname}")
        Text(text = "username: ${user.username}")
        Text(text = "lang: ${user.language_code}")
    }
}

@Composable
fun messageFrameView(message: Message) {
    Column {
        Text(text = "message_id: ${message.message_id}")
        Text(text = "from_user_id: ${message.from_user_id}")
        Text(text = "date: ${message.date}")
        Text(text = "chat_id: ${message.chat_id}")
        Text(text = "forward_from_user_id: ${message.forward_from_user_id}")
        Text(text = "reply_to_message_id: ${message.reply_to_message_id}")
        Text(text = "text: ${message.text}")
        Text(text = "animation_id: ${message.animation_id}")
        Text(text = "audio_id: ${message.audio_id}")
        Text(text = "document_id: ${message.document_id}")
        Text(text = "sticker_id: ${message.sticker_id}")
        Text(text = "video_id: ${message.video_id}")
        Text(text = "voice_id: ${message.voice_id}")
    }
}

@Composable
fun chatPermissionFrameView(chatPermission: ChatPermission) {
    Column {
        Text(text = "id_chat: ${chatPermission.id_chat}")
        Text(text = "can_send_messages: ${chatPermission.can_send_messages}")
        Text(text = "can_send_media_messages: ${chatPermission.can_send_media_messages}")
        Text(text = "can_send_polls: ${chatPermission.can_send_polls}")
        Text(text = "can_send_other_messages: ${chatPermission.can_send_other_messages}")
        Text(text = "can_add_web_page_previews: ${chatPermission.can_add_web_page_previews}")
        Text(text = "can_change_info: ${chatPermission.can_change_info}")
        Text(text = "can_invite_users: ${chatPermission.can_invite_users}")
        Text(text = "can_pin_messages: ${chatPermission.can_pin_messages}")
        Text(text = "can_manage_topics: ${chatPermission.can_manage_topics}")
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