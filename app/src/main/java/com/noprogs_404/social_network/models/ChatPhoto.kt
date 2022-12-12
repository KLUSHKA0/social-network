package com.noprogs_404.social_network.models

data class ChatPhoto(
    val id_photo: Int,
    var small_file_id: String,
    var small_file_unique_id: String,
    var big_file_id: String,
    var big_file_unique_id: String
)
