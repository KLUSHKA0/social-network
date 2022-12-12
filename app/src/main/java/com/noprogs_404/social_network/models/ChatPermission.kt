package com.noprogs_404.social_network.models

data class ChatPermission (
    val id_chat: Int,
    var can_send_messages : Boolean = true,
    var can_send_media_messages : Boolean = true,
    var can_send_polls : Boolean = true,
    var can_send_other_messages : Boolean = true,
    var can_add_web_page_previews : Boolean = true,
    var can_change_info : Boolean = true,
    var can_invite_users : Boolean = true,
    var can_pin_messages : Boolean = true,
    var can_manage_topics : Boolean = true,
) {}