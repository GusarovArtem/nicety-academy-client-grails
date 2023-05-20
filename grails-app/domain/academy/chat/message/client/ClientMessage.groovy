package academy.chat.message.client

import academy.chat.message.ChatMessage
import academy.user.client.Client

class ClientMessage extends ChatMessage {

    Client client

    static constraints = {
        client nullable: false
    }
}
