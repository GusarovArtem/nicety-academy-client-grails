package academy.communication.websocket.chat


import org.springframework.web.socket.*

/* FIXME */
class ChatWebSocketService implements WebSocketHandler {

    def clientChatService

    @Override
    void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String clientId = UUID.randomUUID().toString()
        session.getAttributes().put("clientId", clientId)
    }

    @Override
    void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message
            String payload = textMessage.getPayload()

//            chatService.saveChatMessage(chatMessage)

            // Broadcast the message to all connected clients
            session.sendMessage(new TextMessage(payload))
        }
    }

    @Override
    void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // Called when a transport error occurs
    }

    @Override
    void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        String clientId = session.getAttributes().get("clientId")
//        clientChatService.closeChat(clientId)
    }

    @Override
    boolean supportsPartialMessages() {
        return false
    }
}
