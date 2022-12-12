package com.noprogs_404.social_network.models

import java.util.Date

data class Message(
    val message_id: Int,
    var from_user_id: Int,
    var date: Date,
    var chat_id: Int,
    var forward_from_user_id: Int? = null,
    var reply_to_message_id: Int? = null,
    var text: String,
    var animation_id: Int? = null,
    var audio_id: Int? = null,
    var document_id: Int? = null,
    var sticker_id: Int? = null,
    var video_id: Int? = null,
    var voice_id: Int? = null,
)
