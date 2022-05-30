package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository {
    public void saveMovie(Movie movie);
    public void removeMovie(Long id);
    public Movie getMovieById(Long id);
    public List<Movie> findAllMovies();
}
