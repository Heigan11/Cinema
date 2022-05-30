package edu.school21.cinema.services;

import edu.school21.cinema.models.Hall;

import java.util.List;

public interface HallService {
    public void saveHall(Hall hall);
    public void removeHall(int id);
    public Hall getHallById(int id);
    public List<Hall> listHalls();
}
