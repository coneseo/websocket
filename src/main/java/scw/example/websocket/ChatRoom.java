package scw.example.websocket;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

@Getter
@Setter
public class ChatRoom {
  private String roomId;
  private String name;

  //stomp 방식
//  private Set<WebSocketSession> sessions = new HashSet<>();

//  @Builder
//  public ChatRoom(String roomId, String name){
//    this.roomId = roomId;
//    this.name = name;
//  }
//
//  public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService){
//    if(chatMessage.getType().equals(ChatMessage.MessageType.ENTER)){
//      sessions.add(session);
//      chatMessage.setMessage(chatMessage.getSender()+"님이 입장하셨습니다.");
//    }
//    sendMessage(chatMessage, chatService);
//  }
//
//  private <T> void sendMessage(T message, ChatService chatService) {
//    sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
//  }전

  //stomp 적용 후
  //pub/sub 방식을 이용하면 국독자 관리가 알아서 되므로 웹소켓 세션관리가 필요없어진다.
  public static ChatRoom create(String name){
    ChatRoom chatRoom = new ChatRoom();
    chatRoom.roomId = UUID.randomUUID().toString();
    chatRoom.name = name;
    return chatRoom;
  }

}
