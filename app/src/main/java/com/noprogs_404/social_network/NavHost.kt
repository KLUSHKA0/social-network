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
    object Chats : ScreenObjects(Constants.Screens.CHATS_SCREEN)
    object Messages : ScreenObjects(Constants.Screens.MESSAGES_SCREEN)
    object ChatPermissions : ScreenObjects(Constants.Screens.CHAT_PERMISSIONS_SCREEN)
    object Login : ScreenObjects(Constants.Screens.LOGIN_SCREEN)
    object ChatList : ScreenObjects(Constants.Screens.CHAT_LIST_SCREEN)
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
    }
}