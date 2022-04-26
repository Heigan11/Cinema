package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

//    @Autowired
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    @Transactional
    public void saveUser(User user) {
            this.userRepository.saveUser(user);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        this.userRepository.removeUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUserByName(String name) {
        return this.userRepository.getUserByName(name);
    }
}
