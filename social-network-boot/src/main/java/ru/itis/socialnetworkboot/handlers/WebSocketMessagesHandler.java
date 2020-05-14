package ru.itis.socialnetworkboot.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.socialnetworkboot.dto.MessageDto;
import ru.itis.socialnetworkboot.model.Dialog;
import ru.itis.socialnetworkboot.repository.interfaces.DialogRepository;

import java.util.HashMap;
import java.util.Map;

@Component
@EnableWebSocket
public class WebSocketMessagesHandler extends TextWebSocketHandler {

//    private final DialogRepository dialogRepository;
//
////    private static final Map<Long, WebSocketSession> sessions = new HashMap<>();
//    private static final Map<Dialog, WebSocketSession> dialogWebSocketSessionHashMap = new HashMap<>();
//
//    private final ObjectMapper objectMapper;
//
//    public WebSocketMessagesHandler(DialogRepository dialogRepository, ObjectMapper objectMapper) {
//        this.dialogRepository = dialogRepository;
//        this.objectMapper = objectMapper;
//    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

        session.sendMessage(message);

//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
//
//        String messageText = (String) message.getPayload();
//        MessageDto messageFromJson = objectMapper.readValue(messageText, MessageDto.class);
//
//        Dialog dialog = dialogRepository.getOne(messageFromJson.getDialogId());
//
//        if(!dialogWebSocketSessionHashMap.containsKey(dialog)) {
//            dialogWebSocketSessionHashMap.put(dialog, session);
//        }
//
//        for (WebSocketSession currentSession : dialogWebSocketSessionHashMap.values()) {
//            currentSession.sendMessage(message);
//        }
    }
}
