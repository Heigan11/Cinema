package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class HallRepositoryImpl implements HallRepository {

    @PersistenceContext
//    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public void addHall(Hall hall) {
        entityManager.merge(hall);
        System.out.println("Hall successfully saved. Hall details: " + hall);
    }

    @Override
    public void updateHall(Hall hall) {
        Hall temp = entityManager.find(Hall.class, hall.getId());
        if (temp != null) {
//            movieHall.setSessionList(temp.getSessionList());
            entityManager.merge(hall);
        }
        System.out.println("Hall successfully updated. Hall details: " + entityManager.find(Hall.class, hall.getId()));
    }

    @Override
    public void removeHall(int id) {
        Hall hall = entityManager.find(Hall.class, id);
        if (hall != null)
            entityManager.remove(hall);
    }

    @Override
    public Hall getHallById(int id) {
        Hall hall = entityManager.find(Hall.class, id);
        System.out.println("Hall successfully loaded. Hall details: " + hall);
        return entityManager.find(Hall.class, id);
    }

    @Override
    public List<Hall> listHalls() {
        return entityManager.createQuery("Select f from Hall as f order by f.id", Hall.class).getResultList();
    }
}
