package edu.school21.cinema.services;

import edu.school21.cinema.models.Movie;
import edu.school21.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

//    @Override
//    @Transactional
//    public void addMovie(Movie movie) {
//        this.movieRepository.addMovie(movie);
//    }
//
//    @Override
//    @Transactional
//    public void updateMovie(Movie movie) {
//        this.movieRepository.updateMovie(movie);
//    }

    @Override
    @Transactional
    public void saveMovie(Movie movie) {
        this.movieRepository.saveMovie(movie);
    }

    @Override
    @Transactional
    public void removeMovie(Long id) {
        this.movieRepository.removeMovie(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Movie getMovieById(Long id) {
        return this.movieRepository.getMovieById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAllMovies() {
        return this.movieRepository.findAllMovies() ;
    }
}
