package edu.school21.cinema.services;

import edu.school21.cinema.models.Message;
import edu.school21.cinema.models.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public void removeUser(Long id);
    public List<User> getUserByName(String name);
    public boolean isUser(User user);
}
