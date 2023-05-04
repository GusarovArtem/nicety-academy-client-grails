import academy.jwt.JwtAuthProviderService
import org.springframework.web.client.RestTemplate
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor

// Place your Spring DSL code here
beans = {
    restTemplate(RestTemplate)

    jwtAuthProviderService(JwtAuthProviderService) {
        jwtValidatorService = ref('jwtValidatorService')
        restTemplate = ref('restTemplate')
    }
}

springWebsocket {
    handshakeInterceptors = [new HttpSessionHandshakeInterceptor()]
    endpoints {
        chat {
            uri = "/chat"
            bean = "chatEndpoint"
        }
    }
}