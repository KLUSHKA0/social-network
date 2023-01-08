package com.noprogs_404.social_network.db

import com.noprogs_404.social_network.models.Chat
import com.noprogs_404.social_network.models.ChatPermission
import com.noprogs_404.social_network.models.Message
import com.noprogs_404.social_network.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.sql.Connection
import java.sql.DriverManager
import kotlin.concurrent.thread
import kotlin.properties.Delegates

class Database {

    private lateinit var connection: Connection
    private var models: Models = Models()
    private var url = "jdbc:postgresql://%s:%d/%s"

    private val host: String = "10.0.2.2"
    private val database: String = "socialnetwork"
    private val port: Int = 5432
    private val user: String = "postgres"
    private val pass: String = "SAnikKL1"

    private var status by Delegates.notNull<Boolean>()

    private fun connect() {
        val thread = Thread {
            try {
                Class.forName("org.postgresql.Driver")
                connection = DriverManager.getConnection(url, user, pass)
                status = true
                println("connected:$status")
            } catch (e: Exception) {
                status = false
                println(e.message)
                e.printStackTrace()
            }
        }

        thread.start()


        try {
            thread.join()
        } catch (e: Exception) {
            e.printStackTrace()
            this.status = false
        }
    }


    //region user

    // CREATE
    fun addUser(user: User) {
        thread {
            connection.prepareStatement(models.addUser(user)).execute()
        }
    }

    // READ
    fun getUsers(): Flow<User> = flow {
        val res = connection.prepareStatement(models.getUsers()).executeQuery()
        while (res.next()) {
            emit(models.convertUser(res))
        }
    }

    // UPDATE
    fun updateUser(id: Int, user: User) {}

    // DELETE
    fun deleteUser(id: Int) {
        thread {
            connection.prepareStatement(models.deleteUser(id)).execute()
        }
    }

//    // DELETE
//    fun deleteLastUser(id: Int) {
//        thread {
//            connection.prepareStatement(models.deleteUser(id)).execute()
//        }
//    }

    fun getLastUserId(): Flow<Int> = flow {
        val res = connection.prepareStatement(models.lastUserId()).executeQuery()
        while (res.next()) {
            emit(res.getInt("last_value"))
        }
    }

    //endregion


    //region chat

    // CREATE
    fun addChat(chat: Chat) {
        thread {
            connection.prepareStatement(models.addChat(chat)).execute()
        }
    }

    // READ
    fun getChats(): Flow<Chat> = flow {
        val res = connection.prepareStatement(models.getChats()).executeQuery()

        while (res.next()) {
            emit(models.convertChat(res))
        }
    }

    // UPDATE
    fun updateChat(id: Int, chat: Chat) {}

    // DELETE
    fun deleteChat(id: Int) {
        thread {
            connection.prepareStatement(models.deleteChat(id)).execute()
        }
    }

    fun getLastChatId(): Flow<Int> = flow {
        val res = connection.prepareStatement(models.lastChatId()).executeQuery()
        while (res.next()) {
            emit(res.getInt("last_value"))
        }
    }

    //endregion


//    //region chat permission
//
//    // CREATE
//    fun addChatPermission(chatPermission: ChatPermission) {
//        thread {
//            connection.prepareStatement(models.addChatPermission(chatPermission)).execute()
//        }
//    }
//
//    // READ
//    fun getChatPermissions(): Flow<ChatPermission> = flow {
//        val res = connection.prepareStatement(models.getChatPermissions()).executeQuery()
//
//        while (res.next()) {
//            emit(models.convertChatPermission(res))
//        }
//    }
//
//    // UPDATE
//    fun updateChatPermission(id: Int, chatPermission: ChatPermission) {}
//
//    // DELETE
//    fun deleteChatPermission(id: Int) {
//        thread {
//            connection.prepareStatement(models.deleteChatPermission(id)).execute()
//        }
//    }
//
//    fun getLastChatPermissionId(): Flow<Int> = flow {
//        val res = connection.prepareStatement(models.lastChatPermissionId()).executeQuery()
//        while (res.next()) {
//            emit(res.getInt("last_value"))
//        }
//    }
//
//    //endregion


    //region messages

    // CREATE
    fun addMessage(message: Message) {
        thread {
            connection.prepareStatement(models.addMessage(message)).execute()
        }
    }

    // READ
    fun getMessages(): Flow<Message> = flow {
        val res = connection.prepareStatement(models.getMessages()).executeQuery()

        while (res.next()) {
            emit(models.convertMessage(res))
        }
    }

    // UPDATE
    fun updateMessage(id: Int, message: Message) {}

    // DELETE
    fun deleteMessage(id: Int) {
        thread {
            connection.prepareStatement(models.deleteMessage(id)).execute()
        }
    }

    fun getLastMessageId(): Flow<Int> = flow {
        val res = connection.prepareStatement(models.lastMessageId()).executeQuery()
        while (res.next()) {
            emit(res.getInt("last_value"))
        }
    }

    //endregion

    init {
        this.url = String.format(this.url, this.host, this.port, this.database)
        connect()
    }


}