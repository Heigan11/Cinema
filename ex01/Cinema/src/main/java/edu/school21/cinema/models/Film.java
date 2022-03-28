package edu.school21.cinema.models;

import lombok.Data;

@Data
public class Film {
    private String name;
    private String posterUrl;

    public Film(Movie movie){
        this.name = movie.getTitle();
        this.posterUrl = movie.getPosterUrl();
    }
}
