package com.noprogs_404.social_network.repo

import androidx.compose.runtime.mutableStateListOf
import com.noprogs_404.social_network.db.Database
import com.noprogs_404.social_network.models.Chat
import com.noprogs_404.social_network.models.ChatPermission
import com.noprogs_404.social_network.models.Message
import com.noprogs_404.social_network.models.User
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class MainViewModel() {


    var db = Database()

    val userList: MutableList<User> = mutableStateListOf()
    val chatList: MutableList<Chat> = mutableStateListOf()
    val chatPermissionList: MutableList<ChatPermission> = mutableStateListOf()
    val messageList: MutableList<Message> = mutableStateListOf()

    var lastUserId by Delegates.notNull<Int>()


    @OptIn(DelicateCoroutinesApi::class)
    private fun getUsers() {
        GlobalScope.launch {
            db.getUsers().collect { u -> userList.add(u) }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun addUser(user: User) {
        GlobalScope.launch {
            lastUserId += 1
            val us = User(
                id = lastUserId,
                is_bot = user.is_bot,
                name = user.name,
                surname = user.surname,
                username = user.username,
                language_code = user.language_code,
                is_premium = user.is_premium
            )
            db.addUser(us)
            userList.add(us)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getLastUserId() {
        GlobalScope.launch {
            db.getLastId().collect { i -> lastUserId = i }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getChats() {
        GlobalScope.launch {
            db.getChats().collect { c -> chatList.add(c) }
        }
    }

    private fun getChatPermissions() {

    }

    private fun getMessages() {

    }


    init {

        this.db = Database()
        this.getUsers()
        this.getLastUserId()
        this.getChats()
        this.getChatPermissions()
        this.getMessages()
    }
}