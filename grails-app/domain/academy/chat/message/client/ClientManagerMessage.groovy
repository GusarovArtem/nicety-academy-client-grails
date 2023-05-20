package academy.chat.message.client

import academy.chat.message.ChatMessage
import academy.user.staff.management.ClientManager

class ClientManagerMessage extends ChatMessage {

    ClientManager manager

    static constraints = {
        manager nullable: false
    }
}
