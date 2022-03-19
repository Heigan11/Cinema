package edu.school21.cinema.services;

import edu.school21.cinema.models.Movie;

import java.util.List;

public interface MovieService {
    public void addMovie(Movie movie);
    public void updateMovie(Movie movie);
    public void removeMovie(int id);
    public Movie getMovieById(int id);
    public List<Movie> listMovies();
}
