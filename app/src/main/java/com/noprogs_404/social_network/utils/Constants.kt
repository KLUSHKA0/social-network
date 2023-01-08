package com.noprogs_404.social_network.utils

import com.noprogs_404.social_network.models.User


lateinit var user: User

object Constants {

    const val APP_NAME = "Social Network"

//    object db {
//        const val URL_DATABASE = "jdbc:postgresql://%s:%d/%s"
//        const val HOST = "10.0.2.2"
//        const val DATABASE = "socialnetwork"
//        const val PORT = 5432
//        const val USER = "postgres"
//        const val PASSWORD = "SAnikKL1"
//    }

    object Screens {
        const val CHAT_LIST_SCREEN = "chat_list_screen"
        const val MAIN_SCREEN = "main_screen"

        const val USERS_SCREEN = "users_screen"
        const val ADD_USER_SCREEN = "add_user_screen"
        const val DELETE_USER_SCREEN = "delete_user_screen"

        const val CHATS_SCREEN = "chats_screen"
        const val ADD_CHAT_SCREEN = "add_chat_screen"
        const val DELETE_CHAT_SCREEN = "delete_chat_screen"

        const val MESSAGES_SCREEN = "messages_screen"
        const val ADD_MESSAGE_SCREEN = "add_message_screen"
        const val DELETE_MESSAGE_SCREEN = "delete_message_screen"

        const val CHAT_PERMISSIONS_SCREEN = "chat_permissions_screen"
        const val LOGIN_SCREEN = "login_screen"
        const val ADD_CHAT_PERMISSIONS_SCREEN = "add_chat_permissions_screen"
        const val DELETE_CHAT_PERMISSIONS_SCREEN = "delete_chat_permissions_screen"
    }
}