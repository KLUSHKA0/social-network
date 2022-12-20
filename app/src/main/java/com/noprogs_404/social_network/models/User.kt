package com.noprogs_404.social_network.models

data class User(
    val id: Int = -1,
    var is_bot: Boolean = false,
    var name: String,
    var surname: String,
    var username: String,
    var language_code: String,
    var is_premium: Boolean = false
)
