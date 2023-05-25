package academy.domain.chat.client

import academy.chat.Chat
import academy.domain.chat.ChatService
import academy.chat.ChatMessageCommand
import academy.chat.message.client.ClientMessage
import academy.user.client.Client
import grails.gorm.transactions.Transactional

@Transactional
class ClientChatService extends ChatService {

    def clientService

    @Override
    def saveMessage(ChatMessageCommand command) {
        Client user = clientService.findOrSave()

        persistNew(ClientMessage) {
            client = user
            chat = command.chat ?: createChat(user)
            message = command.message
        }
    }

    def createChat(Client user) {
        persistNew(Chat) {
            client = user
            createdOn = new Date()
        }
    }
}
