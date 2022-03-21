package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.MovieService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SessionsController {

    private final SessionService sessionService;
    private final MovieService movieService;
    private final HallService hallService;

    @Autowired
    public SessionsController(SessionService sessionService, MovieService movieService, HallService hallService) {
        this.sessionService = sessionService;
        this.movieService = movieService;
        this.hallService = hallService;
    }
    
    @GetMapping("/admin/panel/sessions")
    public String Sessions(Model model) {
        model.addAttribute("sessions", sessionService.listSessions());
        model.addAttribute("movies", movieService.listMovies());
        model.addAttribute("halls", hallService.listHalls());
        return "sessions";
    }

    @GetMapping("/admin/panel/sessions/delete/{id}")
    public String deleteSession(@PathVariable("id") Long id) {
        sessionService.removeSession(id);
        return "redirect:/admin/panel/sessions";
    }

    @PostMapping("/admin/panel/sessions/update/{id}")
    public String updateSession(@ModelAttribute("session") Session session) {
        sessionService.updateSession(session);
        return "redirect:/admin/panel/sessions";
    }

//    @PostMapping("/admin/panel/sessions")
//    public String addSession(@ModelAttribute("session") Session session){
//        sessionService.addSession(session);
//        return "redirect:/admin/panel/sessions";
//    }

    @PostMapping("/admin/panel/sessions")
    public String addSession(@ModelAttribute("date") String date){
        System.out.println(date);
//        sessionService.addSession(session);
        return "redirect:/admin/panel/sessions";
    }
}
