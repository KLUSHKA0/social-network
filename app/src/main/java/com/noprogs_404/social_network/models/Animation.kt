package com.noprogs_404.social_network.models

data class Animation (
    val file_id: Int,
    var file_unique_id: Int,
    var width: Int,
    var height: Int,
    var duration: Int,
    var file_name: String,
    var file_size: Int
) {}