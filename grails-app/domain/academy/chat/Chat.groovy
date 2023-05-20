package academy.chat

import academy.chat.message.client.ClientManagerMessage
import academy.chat.message.client.ClientMessage
import academy.user.client.Client

class Chat {

    Client client

    Date createdOn

    boolean isClosed

    static hasMany = [
            clientMessages: ClientMessage,
            clientManagerMessages: ClientManagerMessage
    ]

    static constraints = {
        client nullable: false, unique: true
        createdOn nullable: false, date: true
    }
}
