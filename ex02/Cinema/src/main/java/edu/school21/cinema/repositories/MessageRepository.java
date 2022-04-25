package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository {
    public void saveMessage(Message message);
    public void removeMessage(Long id);
    public Message getMessageById(Long id);
    public List<Message> listMessages();
    public List<Message> getChatHistory(Long id);
}
