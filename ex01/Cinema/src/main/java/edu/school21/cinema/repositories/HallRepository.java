package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository {
    public void saveHall(Hall hall);
    public void removeHall(int id);
    public Hall getHallById(int id);
    public List<Hall> listHalls();
}
