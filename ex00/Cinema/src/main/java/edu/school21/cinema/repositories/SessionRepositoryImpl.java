package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SessionRepositoryImpl implements SessionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSession(Session session) {
        entityManager.merge(session);
        System.out.println("Session successfully saved. Session details: " + session);
    }

    @Override
    public void updateSession(Session session) {
        Session temp = entityManager.find(Session.class, session.getId());
        if (temp != null) {
            entityManager.merge(session);
        }
        System.out.println("Session successfully updated. Session details: " + entityManager.find(Session.class, session.getId()));
    }

    @Override
    public void removeSession(Long id) {
        Session session = entityManager.find(Session.class, id);
        if (session != null)
            entityManager.remove(session);
    }

    @Override
    public Session getSessionById(Long id) {
//        Session Session = entityManager.find(Session.class, id);
//        System.out.println("Session successfully loaded. Session details: " + Session);
        return entityManager.find(Session.class, id);
    }

    @Override
    public List<Session> listSessions() {
//        List<Session> Sessions = entityManager.createQuery("Select f from Session as f order by f.id", Session.class).getResultList();
//        for (Session Session : Sessions)
//            System.out.println("Session: " + Session);
        return entityManager.createQuery("Select f from Session as f order by f.id", Session.class).getResultList();
    }
}
