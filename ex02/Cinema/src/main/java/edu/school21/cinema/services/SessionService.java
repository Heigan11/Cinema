package edu.school21.cinema.services;

import edu.school21.cinema.models.Session;

import java.util.List;

public interface SessionService {
    public void addSession(Session session);
    public void updateSession(Session session);
    public void removeSession(Long id);
    public Session getSessionById(Long id);
    public List<Session> listSessions();
    public List<Session> getSessionByFilm(String filmName);
}
