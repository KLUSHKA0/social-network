package com.noprogs_404.social_network

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.ui.theme.SocialnetworkTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialnetworkTheme {
                val navController = rememberNavController()
                val viewModel = MainViewModel()
                MyAppNavHost(navController = navController, viewModel = viewModel)
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SocialnetworkTheme {
//        Greeting("Android")
//    }
//}