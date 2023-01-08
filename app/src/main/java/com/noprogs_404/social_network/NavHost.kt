package com.noprogs_404.social_network

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.screens.*
import com.noprogs_404.social_network.utils.Constants


sealed class ScreenObjects(val route: String) {
    object Main : ScreenObjects(Constants.Screens.MAIN_SCREEN)

    object Users : ScreenObjects(Constants.Screens.USERS_SCREEN)
    object AddUser : ScreenObjects(Constants.Screens.ADD_USER_SCREEN)
    object DeleteUser : ScreenObjects(Constants.Screens.DELETE_USER_SCREEN)

    object Chats : ScreenObjects(Constants.Screens.CHATS_SCREEN)
    object AddChat : ScreenObjects(Constants.Screens.ADD_CHAT_SCREEN)
    object DeleteChat : ScreenObjects(Constants.Screens.DELETE_CHAT_SCREEN)

    object Messages : ScreenObjects(Constants.Screens.MESSAGES_SCREEN)
    object AddMessage : ScreenObjects(Constants.Screens.ADD_MESSAGE_SCREEN)
    object DeleteMessage : ScreenObjects(Constants.Screens.DELETE_MESSAGE_SCREEN)

    object ChatPermissions : ScreenObjects(Constants.Screens.CHAT_PERMISSIONS_SCREEN)

    object Login : ScreenObjects(Constants.Screens.LOGIN_SCREEN)
    object ChatList : ScreenObjects(Constants.Screens.CHAT_LIST_SCREEN)

    object AddChatPermissions : ScreenObjects(Constants.Screens.ADD_CHAT_PERMISSIONS_SCREEN)
    object DeleteChatPermissions : ScreenObjects(Constants.Screens.DELETE_CHAT_PERMISSIONS_SCREEN)

}

@Composable
fun MyAppNavHost(
    navController: NavHostController,
    viewModel: MainViewModel
) {

    NavHost(
        navController = navController,
        startDestination = ScreenObjects.Login.route
    ) {

        composable(ScreenObjects.Users.route) {
            UsersScreen(navController = navController, viewModel = viewModel)
        }

        // region main
        composable(ScreenObjects.Main.route) {
            MainScreen(
                navController = navController,
                viewModel = viewModel
            )

        }
        //endregion

        //region user
        composable(ScreenObjects.Users.route) {
            UsersScreen(navController = navController, viewModel = viewModel)
        }
        composable(ScreenObjects.AddUser.route) {
            AddUserScreen(navController = navController, viewModel = viewModel)
        }
        composable(ScreenObjects.DeleteUser.route) {
            DeleteUserScreen(navController = navController, viewModel = viewModel)
        }
        //endregion

        //region chat
        composable(ScreenObjects.Chats.route) {
            ChatsScreen(navController = navController, viewModel = viewModel)

        }
        composable(ScreenObjects.Messages.route) {

        }
        composable(ScreenObjects.ChatPermissions.route) {

        }
        composable(ScreenObjects.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }

        composable(ScreenObjects.Login.route) {
            LoginScreen(navController = navController, viewModel = viewModel)
        }

        composable(ScreenObjects.ChatList.route) {
            ChatListScreen(navController = navController, viewModel = viewModel)

        }
        composable(ScreenObjects.AddChat.route) {
            AddChatScreen(navController = navController, viewModel = viewModel)
        }
        composable(ScreenObjects.DeleteChat.route) {
            DeleteChatScreen(navController = navController, viewModel = viewModel
            )

        }
        //endregion

        //region message
        composable(ScreenObjects.Messages.route) {
            MessagesScreen(navController = navController, viewModel = viewModel)
        }
        composable(ScreenObjects.AddMessage.route) {
            //TODO add message
        }
        composable(ScreenObjects.DeleteMessage.route) {
            //TODO delete message
        }
        //endregion

        //region chatPermission
        composable(ScreenObjects.ChatPermissions.route) {
            //TODO chat permission list
        }
        composable(ScreenObjects.AddChatPermissions.route) {
            //TODO add chat permission
        }
        composable(ScreenObjects.DeleteChatPermissions.route) {
            //TODO delete chat permission
        }
        //endregion
    }
}