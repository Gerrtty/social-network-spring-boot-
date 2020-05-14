package ru.itis.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.MessageDto;
import ru.itis.rest.model.Message;
import ru.itis.rest.repository.MessagesRepository;

import java.util.List;

@Service
public class MessagesServiceImpl {

    private final MessagesRepository messagesRepository;

    @Autowired
    public MessagesServiceImpl(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public void addMessage(MessageDto messageDto) {

        Message message = Message.builder()
                .text(messageDto.getText())
//                .userId(Long.parseLong(messageDto.getPageId()))
                .build();

        messagesRepository.save(message);

    }

    public List<Message> getMessages() {

        return messagesRepository.findAll();

    }

}
