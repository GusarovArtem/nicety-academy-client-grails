package academy.chat

import academy.ControllerTrait
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.Validateable
import org.springframework.transaction.annotation.Transactional

@Transactional
class ChatController implements ControllerTrait {

    def clientChatService

    def clientManagerChatService


    def saveClientMessage(ChatMessageCommand command) {
        clientChatService.saveMessage(command)
    }

    @Secured(['ROLE_CLIENT_MANAGER'])
    def saveClientManagerMessage(ChatMessageCommand command) {
        clientManagerChatService.saveMessage(command)
    }

}

class ChatMessageCommand implements Validateable {

    Chat chat

    String message

    static constraints = {
        chat    nullable: true
        message nullable: false
    }
}
