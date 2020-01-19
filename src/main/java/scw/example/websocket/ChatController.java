package scw.example.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {

  private final SimpMessageSendingOperations messagingTemplate;

  @MessageMapping("/chat/message")
  public void message(ChatMessage message) {
    if (ChatMessage.MessageType.JOIN.equals(message.getType()))
      message.setMessage(message.getSender() + "is entered");
    messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
  }
}
