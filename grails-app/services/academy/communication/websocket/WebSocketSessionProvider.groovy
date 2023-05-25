package academy.communication.websocket

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.socket.WebSocketSession

import javax.servlet.ServletContext

class WebSocketSessionProvider {

    @Autowired
    ServletContext servletContext

    WebSocketSessionProvider(ServletContext servletContext) {
        this.servletContext = servletContext
    }

    WebSocketSession getWebSocketSession() {
        def request = servletContext.request
        request?.attributes?.get("org.springframework.web.socket.WebSocketSession")
    }
}
