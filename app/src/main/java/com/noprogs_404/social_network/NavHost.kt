package com.noprogs_404.social_network

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.noprogs_404.social_network.db.Database
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.screens.ChatsScreen
import com.noprogs_404.social_network.screens.MainScreen
import com.noprogs_404.social_network.screens.UsersScreen
import com.noprogs_404.social_network.utils.Constants


sealed class Screans(val route: String) {
    object Main : Screans(Constants.Screens.MAIN_SCREEN)
    object Users : Screans(Constants.Screens.USERS_SCREEN)
    object Chats : Screans(Constants.Screens.CHATS_SCREEN)
    object Messages : Screans(Constants.Screens.MESSAGES_SCREEN)
    object ChatPermissions : Screans(Constants.Screens.CHAT_PERMISSIONS_SCREEN)
}

@Composable
fun MyAppNavHost(
    navController: NavHostController,
    viewModel : MainViewModel
) {

    NavHost(
        navController = navController,
        startDestination = Screans.Main.route
    ) {
        composable(Screans.Users.route) { UsersScreen(navController = navController, viewModel = viewModel) }
        composable(Screans.Chats.route) { ChatsScreen(navController = navController, viewModel = viewModel) }
        composable(Screans.Messages.route) {}
        composable(Screans.ChatPermissions.route) {}
        composable(Screans.Main.route) { MainScreen(navController = navController, viewModel = viewModel)}
//        composable(route = Screans.Login.route) {
//            LoginScreen(
//                onNavigateToChat = { navController.navigate(Screans.Chat.route) },navController = navController, viewModel= viewModel
//            )
//        }
//        composable(Screans.Chat.route) { ChatScreen(navController = navController, viewModel= viewModel) }
    }
}