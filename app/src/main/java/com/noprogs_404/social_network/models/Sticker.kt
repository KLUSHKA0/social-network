package com.noprogs_404.social_network.models

data class Sticker(
    val file_id: Int,
    var file_unique_id: Int,
    var type: String,
    var width: Int,
    var height : Int,
    var is_animated: Boolean,
    var is_video: Boolean,
    var emoji: String,
    var set_name: String,
    var file_size: Int
)
