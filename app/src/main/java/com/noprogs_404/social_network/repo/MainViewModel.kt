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
    fun getUsers() {
        GlobalScope.launch {
            db.getUsers().collect { u -> userList.add(u) }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getLastUserId() {
        GlobalScope.launch {
            db.getLastId().collect { i -> lastUserId = i }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getChats() {
        GlobalScope.launch {
            db.getChats().collect { c -> chatList.add(c) }
        }
    }

    fun getChatPermissions() {

    }

    fun getMessages() {

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