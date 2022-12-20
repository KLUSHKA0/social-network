package com.noprogs_404.social_network.db

import com.noprogs_404.social_network.models.Chat
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
    fun deleteUser(id: Int) {}

    // DELETE
    fun deleteLastUser(id: Int) {
        thread {
            connection.prepareStatement(models.deleteUser(id)).execute()
        }
    }

    fun getLastId(): Flow<Int> = flow {
        val res = connection.prepareStatement(models.lastUserId()).executeQuery()
        while (res.next()) {
            emit(res.getInt("last_value"))
        }
    }

    //endregion


    //region chat

    fun addChat(chat: Chat) {}

    fun getChats(): Flow<Chat> = flow {
        val res = connection.prepareStatement(models.getChats()).executeQuery()

        while (res.next()) {
            emit(models.convertChat(res))
        }
    }

    fun updateChat(id: Int, chat: Chat) {}

    fun deleteChat(id: Int) {}

    //endregion


    //region chat permission

    //endregion


    //region messages

    //endregion

    init {
        this.url = String.format(this.url, this.host, this.port, this.database)
        connect()
    }


}