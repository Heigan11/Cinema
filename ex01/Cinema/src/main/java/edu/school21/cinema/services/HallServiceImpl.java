package edu.school21.cinema.services;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HallServiceImpl implements HallService{

    private final HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

//    @Override
//    @Transactional
//    public void addHall(Hall hall) {
//        if (hall.getSeats() > 0 && hall.getSeats() <= 1000)
//            this.hallRepository.addHall(hall);
//    }

//    @Override
//    @Transactional
//    public void updateHall(Hall hall) {
//        if (hall.getSeats() > 0 && hall.getSeats() <= 1000)
//            this.hallRepository.updateHall(hall);
//    }

    @Override
    @Transactional
    public void saveHall(Hall hall) {
        if (hall.getSeats() > 0 && hall.getSeats() <= 1000)
            this.hallRepository.saveHall(hall);
    }

    @Override
    @Transactional
    public void removeHall(int id) {
        this.hallRepository.removeHall(id);
    }

    @Override
    @Transactional
    public Hall getHallById(int id) {
        return this.hallRepository.getHallById(id);
    }

    @Override
    @Transactional
    public List<Hall> listHalls() {
        return this.hallRepository.listHalls() ;
    }
}
