package com.noprogs_404.social_network.db

import com.noprogs_404.social_network.models.Chat
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

    //endregion
}