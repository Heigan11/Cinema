package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository {
    public void addSession(Session session);
    public void updateSession(Session session);
    public void removeSession(Long id);
    public Session getSessionById(Long id);
    public List<Session> listSessions();
}
