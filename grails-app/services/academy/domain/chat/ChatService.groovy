package academy.domain.chat

import academy.chat.ChatMessageCommand
import academy.domain.persist.PersistingTrait
import grails.gorm.transactions.Transactional

@Transactional
abstract class ChatService implements PersistingTrait {

    abstract saveMessage(ChatMessageCommand command)

}
