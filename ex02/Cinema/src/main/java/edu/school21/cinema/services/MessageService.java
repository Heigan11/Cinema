package edu.school21.cinema.services;

import edu.school21.cinema.models.Message;

import java.util.List;

public interface MessageService {
    public void saveMessage(Message message);
    public void removeMessage(Long id);
    public Message getMessageById(Long id);
    public List<Message> listMessages();
    public List<Message> getChatHistory(Long id);
}
