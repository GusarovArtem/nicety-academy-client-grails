package academy.chat.message

import academy.chat.Chat

class ChatMessage {

    Chat chat

    String message

    static constraints = {
        chat    nullable: false
        message nullable: false
    }
}
