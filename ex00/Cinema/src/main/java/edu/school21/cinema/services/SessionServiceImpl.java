package edu.school21.cinema.services;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    @Transactional
    public void addSession(Session session) {
        this.sessionRepository.addSession(session);
    }

    @Override
    @Transactional
    public void updateSession(Session session) {
        this.sessionRepository.updateSession(session);
    }

    @Override
    @Transactional
    public void removeSession(Long id) {
        this.sessionRepository.removeSession(id);
    }

    @Override
    @Transactional
    public Session getSessionById(Long id) {
        return this.sessionRepository.getSessionById(id);
    }

    @Override
    @Transactional
    public List<Session> listSessions() {
        return this.sessionRepository.listSessions() ;
    }
}
