package academy.domain.chat.client

import academy.domain.chat.ChatService
import academy.chat.ChatMessageCommand
import academy.chat.message.client.ClientManagerMessage
import academy.user.staff.management.ClientManager
import grails.gorm.transactions.Transactional

@Transactional
class ClientManagerChatService extends ChatService {

    def securityService

    @Override
    def saveMessage(ChatMessageCommand command) {
        ClientManager user = (ClientManager) securityService.currentUser()

        persistNew(ClientManagerMessage) {
            manager = user
            chat = command.chat
            message = command.message
        }
    }
}
