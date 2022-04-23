package edu.school21.cinema.services;

import edu.school21.cinema.models.Message;
import edu.school21.cinema.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

//    private final MessageRepository messageRepository;
//
//    @Autowired
//    public MessageServiceImpl(MessageRepository messageRepository) {
//        this.messageRepository = messageRepository;
//    }
//
//    @Override
//    @Transactional
//    public void saveMessage(Message message) {
//            this.messageRepository.saveMessage(message);
//    }
//
//    @Override
//    @Transactional
//    public void removeMessage(int id) {
//        this.messageRepository.removeMessage(id);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Message getMessageById(int id) {
//        return this.messageRepository.getMessageById(id);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<Message> listMessages() {
//        return this.messageRepository.listMessages() ;
//    }
}
