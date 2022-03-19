package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Movie;
import edu.school21.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MoviesController {

    private final MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/admin/panel/films")
    public String Movies(Model model) {
        model.addAttribute("Movies", movieService.listMovies());
        return "films";
    }

    @GetMapping("/admin/panel/films/delete/{id}")
    public String deleteMovie(@PathVariable("id") int id) {
        movieService.removeMovie(id);
        return "redirect:/admin/panel/films";
    }

    @PostMapping("/admin/panel/films/update/{id}")
    public String updateMovie(@ModelAttribute("Movie") Movie movie) {
        movieService.updateMovie(movie);
        return "redirect:/admin/panel/films";
    }

    @PostMapping("/admin/panel/films")
    public String addMovie(@ModelAttribute("Movie") Movie movie){
        movieService.addMovie(movie);
        return "redirect:/admin/panel/films";
    }
}
