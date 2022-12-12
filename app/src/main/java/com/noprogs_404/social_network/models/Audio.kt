package com.noprogs_404.social_network.models

data class Audio(
    val file_id: Int,
    var file_unique_id: Int,
    var duration: Int,
    var title: String,
    var file_name: String,
    var file_size: Int
)