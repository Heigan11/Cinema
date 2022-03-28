package edu.school21.cinema.servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.school21.cinema.models.Session;
import edu.school21.cinema.models.SessionSearch;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.MovieService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class SessionsSearchController {

    private final SessionService sessionService;
    private final MovieService movieService;
    private final HallService hallService;

    @Autowired
    public SessionsSearchController(SessionService sessionService, MovieService movieService, HallService hallService) {
        this.sessionService = sessionService;
        this.movieService = movieService;
        this.hallService = hallService;
    }

    @GetMapping("/sessions/search")
    @ResponseBody
    public String SessionsSearch(@RequestParam("filmName") String filmName) throws JsonProcessingException {
        System.out.println("filmName = " + filmName);
        List<Session> sessionList = sessionService.getSessionByFilm(filmName);
        List<SessionSearch> sessionSearchList = new ArrayList<>();
        for (Session session : sessionList){
            sessionSearchList.add(new SessionSearch(session));
        }
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(sessionSearchList);

        return json;
    }

    @GetMapping("/sessions")
    public String Sessions() {
        return "sessionsSearch";
    }

//    @GetMapping("/admin/panel/sessions")
//    public String Sessions(Model model) {
//        model.addAttribute("sessions", sessionService.listSessions());
//        model.addAttribute("movies", movieService.listMovies());
//        model.addAttribute("halls", hallService.listHalls());
//        return "sessions";
//    }

//    @GetMapping("/admin/panel/sessions/delete/{id}")
//    public String deleteSession(@PathVariable("id") Long id) {
//        sessionService.removeSession(id);
//        return "redirect:/admin/panel/sessions";
//    }
//
//    @PostMapping("/admin/panel/sessions/update/{id}")
//    public String updateSession(@PathVariable("id") Long id,
//                                @ModelAttribute("cost") int cost) {
//        Session session = sessionService.getSessionById(id);
//        session.setCost(cost);
//        sessionService.updateSession(session);
//        return "redirect:/admin/panel/sessions";
//    }
//
//    @PostMapping("/admin/panel/sessions")
//    public String addSession(@ModelAttribute("date") String date,
//                             @ModelAttribute("cost") int cost,
//                             @ModelAttribute("movie") Long movie_id,
//                             @ModelAttribute("hall") int hall_id){
//
//        sessionService.addSession(new Session(0L,LocalDateTime.parse(date), cost,
//                movieService.getMovieById(movie_id), hallService.getHallById(hall_id)));
//        return "redirect:/admin/panel/sessions";
//    }
}
