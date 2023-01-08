package com.noprogs_404.social_network.repo

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
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

    var userList: MutableMap<Int, User> = mutableStateMapOf()
    var chatList: MutableMap<Int, Chat> = mutableStateMapOf()
    val chatPermissionList: MutableMap<Int, ChatPermission> = mutableStateMapOf()
    var messageList: MutableMap<Int, Message> = mutableStateMapOf()

    var lastUserId by Delegates.notNull<Int>()
    var lastChatId by Delegates.notNull<Int>()
    var lastMessageId by Delegates.notNull<Int>()

    @OptIn(DelicateCoroutinesApi::class)
    private fun getUsers() {
        GlobalScope.launch {
            db.getUsers().collect { u -> userList[u.id] = u }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun addUser(user: User) {
        GlobalScope.launch {
            lastUserId += 1
            user.id = lastUserId
            db.addUser(user)
            userList[lastUserId] = user
        }
    }

    fun deleteUser(id: Int) {
        GlobalScope.launch {
            db.deleteUser(id)
            userList.remove(id)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getLastUserId() {
        GlobalScope.launch {
            db.getLastUserId().collect { i -> lastUserId = i }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getChats() {
        GlobalScope.launch {
            db.getChats().collect { c -> chatList[c.id] = c }
        }
    }

    fun addChat(chat: Chat) {
        GlobalScope.launch {
            lastChatId+=1
            chat.id = lastChatId
            db.addChat(chat)
            chatList[lastChatId] = chat
        }
    }

    fun deleteChat(id: Int) {
        GlobalScope.launch {
            db.deleteChat(id)
            chatList.remove(id)
        }
    }

    private fun getChatPermissions() {

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getMessages() {
        GlobalScope.launch {
            db.getMessages().collect { m -> messageList[m.message_id] = m }
        }
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