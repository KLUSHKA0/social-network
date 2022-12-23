package com.noprogs_404.social_network.db

import com.noprogs_404.social_network.models.Chat
import com.noprogs_404.social_network.models.ChatPermission
import com.noprogs_404.social_network.models.Message
import com.noprogs_404.social_network.models.User
import java.sql.ResultSet

class Models {


    //region user

    fun getUsers(): String {
        return "SELECT * FROM users"
    }

    fun getUser(id: Int): String {
        return "SELECT * FROM users WHERE id=$id"
    }

    fun convertUser(res: ResultSet): User {
        return User(
            res.getInt("id"),
            res.getBoolean("is_bot"),
            res.getString("name"),
            res.getString("surname"),
            res.getString("username"),
            res.getString("language_code"),
            res.getBoolean("is_premium")
        )
    }

    fun addUser(user: User): String {
        return  "INSERT INTO users " +
                "(is_bot, name, surname, username, language_code, is_premium) " +
                "VALUES " +
                "(${user.is_bot}, '${user.name}', '${user.surname}', '${user.username}', '${user.language_code}', ${user.is_premium})"
    }

    fun updateUser(id: Int, user: User) {}

    fun deleteUser(id: Int): String {
        return "DELETE FROM users WHERE id=$id"
    }

    fun lastUserId(): String {
        return "SELECT * FROM users_id_seq"
    }

    //endregion


    //region chat

    fun getChats(): String {
        return "SELECT * FROM chat"
    }

    fun getChat(id: Int): String {
        return "SELECT * FROM chat WHERE id=$id"
    }

    fun convertChat(res: ResultSet): Chat {
        return Chat(
            res.getInt("id"),
            res.getString("type"),
            res.getString("title"),
            res.getString("username"),
            res.getString("first_name"),
            res.getString("last_name"),
            res.getBoolean("is_forum"),
            res.getInt("photo_id"),
            res.getString("bio"),
            res.getString("description"),
            res.getInt("pinned_message_id"),
        )
    }

    fun addChat(chat: Chat): String {
        return "INSERT INTO chat " +
                "(type, title, username, first_name, last_name, is_forum, photo_id, bio, description, pinned_message_id) " +
                "VALUES " +
                "('${chat.type}', '${chat.title}', '${chat.username}', '${chat.first_name}', '${chat.last_name}', ${chat.is_forum}, ${chat.photo_id}, '${chat.bio}', '${chat.description}', ${chat.pinned_message_id})"
    }

    fun updateChat(id: Int, chat: Chat) {}

    fun deleteChat(id: Int): String {
        return "DELETE FROM chat WHERE id=$id"
    }

    fun lastChatId(): String {
        return "SELECT * FROM chat_id_seq" // TODO
    }
    //endregion

    //region message

    fun getMessages(): String {
        return "SELECT * FROM message"
    }

    fun getMessage(id: Int): String {
        return "SELECT * FROM message WHERE id=$id"
    }

    fun convertMessage(res: ResultSet): Message {
        return Message(
            res.getInt("message_id"),
            res.getInt("from_user_id"),
            res.getDate("date"),
            res.getInt("chat_id"),
            res.getInt("forward_from_user_id"),
            res.getInt("reply_to_message_id"),
            res.getString("text"),
            res.getInt("animation_id"),
            res.getInt("audio_id"),
            res.getInt("document_id"),
            res.getInt("sticker_id"),
            res.getInt("video_id"),
            res.getInt("voice_id")
        )
    }

    fun addMessage(message: Message): String {
        return "INSERT INTO message " +
                "(from_user_id, date, chat_id, forward_from_user_id, reply_to_message_id, text, animation_id, audio_id, document_id, sticker_id, video_id, voice_id) " +
                "VALUES " +
                "(${message.from_user_id}, '${message.date}', ${message.chat_id}, ${message.forward_from_user_id}, ${message.reply_to_message_id}, '${message.text}', ${message.animation_id}, ${message.audio_id}, ${message.document_id}, ${message.sticker_id}, ${message.video_id}, ${message.voice_id})"
    }

    fun updateMessage(id: Int, message: Message) {}

    fun deleteMessage(id: Int): String {
        return "DELETE FROM message WHERE id=$id"
    }

    fun lastMessageId(): String {
        return "SELECT * FROM message_id_seq" // TODO
    }

    //endregion

//    //region chatPermission
//
//    fun getChatPermissions(): String {
//        return "SELECT * FROM chat_permissions"
//    }
//
//    fun getChatPermission(id: Int): String {
//        return "SELECT * FROM chat_permissions WHERE id=$id"
//    }
//
//    fun convertChatPermission(res: ResultSet): ChatPermission {
//
//    }
//
//    fun addChatPermission(chatPeermission: ChatPermission): String {
//
//    }
//
//    fun updateChatPermission(id: Int, chatPeermission: ChatPermission) {}
//
//    fun deleteChatPermission(id: Int): String {
//        return "DELETE FROM chat_permissions WHERE id=$id"
//    }
//
//    fun lastChatPermissionId(): String {
//        return "SELECT * FROM message_id_seq" // TODO
//    }
//
//    //endregion

}