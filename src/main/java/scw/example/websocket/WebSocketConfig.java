package scw.example.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
@RequiredArgsConstructor
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
  private final WebSocketHandler webSocketHandler;

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    //websocket에 접속하기위한 end point path를 지정하고 다른 서버에서도 접속이 가능하도록
    //CORS:setAllowedOrigins("*") 설정을 추가
    registry.addHandler(webSocketHandler,"/ws/chat").setAllowedOrigins("*");
  }
}
