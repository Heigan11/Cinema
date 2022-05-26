package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    public void saveUser(User user);
    public void removeUser(Long id);
    public List<User> getUserByName(String name);
    public User findUserById(Long id);
}
