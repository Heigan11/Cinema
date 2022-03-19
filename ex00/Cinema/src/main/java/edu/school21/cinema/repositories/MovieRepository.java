package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository {
    public void addMovie(Movie movie);
    public void updateMovie(Movie movie);
    public void removeMovie(int id);
    public Movie getMovieById(int id);
    public List<Movie> listMovies();
}
