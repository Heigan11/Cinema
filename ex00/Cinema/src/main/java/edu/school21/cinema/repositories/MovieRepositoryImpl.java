package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addMovie(Movie movie) {
        entityManager.merge(movie);
        System.out.println("Movie successfully saved. Movie details: " + movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        Movie temp = entityManager.find(Movie.class, movie.getId());
        if (temp != null) {
            entityManager.merge(movie);
        }
        System.out.println("Movie successfully updated. Movie details: " + entityManager.find(Movie.class, movie.getId()));
    }

    @Override
    public void removeMovie(int id) {
        Movie movie = entityManager.find(Movie.class, id);
        if (movie != null)
            entityManager.remove(movie);
    }

    @Override
    public Movie getMovieById(int id) {
        Movie movie = entityManager.find(Movie.class, id);
        System.out.println("Movie successfully loaded. Movie details: " + movie);
        return entityManager.find(Movie.class, id);
    }

    @Override
    public List<Movie> listMovies() {
        List<Movie> movies = entityManager.createQuery("Select f from Movie as f order by f.id", Movie.class).getResultList();
        for (Movie movie : movies)
            System.out.println("Movie: " + movie);
        return entityManager.createQuery("Select f from Movie as f order by f.id", Movie.class).getResultList();
    }
}
