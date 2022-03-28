package edu.school21.cinema.models;

import edu.school21.cinema.services.SessionService;
import lombok.Data;

@Data
public class SessionSearch {
    private Long id;
    private String dateTime;
    private Film film;

    public SessionSearch(Session session){
        this.id = session.getId();
        this.dateTime = session.getDate();
        this.film = new Film(session.getMovie());
    }
}
