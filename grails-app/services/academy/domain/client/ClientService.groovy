package academy.domain.client

import academy.user.client.Client
import grails.gorm.transactions.Transactional

@Transactional
class ClientService {

    def webSocketSession

    String clientId() {
        webSocketSession.attributes.get("clientId")
    }

    Client findOrSave() {
        Client.findOrSaveById(clientId())
    }

}
