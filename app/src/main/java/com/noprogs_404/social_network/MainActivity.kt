package com.noprogs_404.social_network

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.noprogs_404.social_network.db.Database
import com.noprogs_404.social_network.models.User
import com.noprogs_404.social_network.repo.MainViewModel
import com.noprogs_404.social_network.ui.theme.SocialnetworkTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlin.properties.Delegates


class MainActivity : ComponentActivity() {

    private lateinit var db: Database
    private var lastId by Delegates.notNull<Int>()
    private var userList: MutableList<User> = mutableStateListOf()

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("CoroutineCreationDuringComposition", "MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialnetworkTheme {
                val navController = rememberNavController()
                val viewModel = MainViewModel()
                MyAppNavHost(navController = navController, viewModel = viewModel)
//region todo

//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    db = Database()
//
//                    GlobalScope.launch {
//                        db.getUsers().collect { u -> userList.add(u) }
//                        db.getLastId().collect { i -> lastId = i}
//                    }
//                    Column {
//                        Row {
//                            Button(onClick = {
//                                lastId+=1
//                                GlobalScope.launch {
//
//                                    val us = User(
//                                        id = lastId,
//                                        is_bot = false,
//                                        name = "name",
//                                        surname = "surname",
//                                        username = "username",
//                                        language_code = "ru",
//                                        is_premium = true
//                                    )
//                                    db.addUser(us)
//                                    userList.add(us)
//                                }
//                            }) {
//                                Text("Add user", fontSize = 20.sp)
//                            }
//
//                            Button(onClick = {
//                                db.deleteLastUser(userList.last().id)
//                                userList.removeAt(userList.size-1)
//                            }) {
//                                Text("Delete last user", fontSize = 20.sp)
//                            }
//                        }
//
//                        LazyColumn {
//                            items(userList) { u ->
//                                Column {
//                                    Text(text = "id: ${u.id}")
//                                    Text(text = "name: ${u.name}")
//                                    Text(text = "bot?: ${u.is_bot}")
//                                    Text(text = "surname: ${u.surname}")
//                                    Text(text = "username: ${u.username}")
//                                    Text(text = "language: ${u.language_code}")
//                                    Text(text = "premium: ${u.is_premium}")
//                                }
//                            }
//                        }
//
//
//                    }
//                }
//            }
//        }
//endregion
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SocialnetworkTheme {
        Greeting("Android")
    }
}