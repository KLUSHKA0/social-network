package com.noprogs_404.social_network.models

data class Chat(
    val id: Int,
    var type: String,
    var title: String = "",
    var username: String,
    var first_name: String,
    var last_name: String,
    var is_forum: Boolean = false,
    var photo_id: Int? = null,
    var bio: String? = "",
    var description: String? = "",
    var pinned_message_id: Int? = null
) {}
