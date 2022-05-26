package edu.school21.cinema.repositories;

import edu.school21.cinema.models.UserAvatar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAvatarRepository {
    public UserAvatar save(UserAvatar userAvatar);
    public List<UserAvatar> findAllByUserId(Long id);
    public UserAvatar findById(Long id);
}
