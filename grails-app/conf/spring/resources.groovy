import academy.security.jwt.JwtAuthProviderService
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor

import javax.servlet.ServletContext
import academy.communication.websocket.WebSocketSessionProvider

// Place your Spring DSL code here
beans = {
    restTemplate(RestTemplate)

    jwtAuthProviderService(JwtAuthProviderService) {
        jwtValidatorService = ref('jwtValidatorService')
        restTemplate = ref('restTemplate')
    }

    webSocketSession(WebSocketSessionProvider)

}

@Bean
HttpSessionHandshakeInterceptor httpSessionHandshakeInterceptor() {
    new HttpSessionHandshakeInterceptor()
}