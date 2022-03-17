package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HallsController {

    private final HallService hallService;

    @Autowired
    public HallsController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/admin/panel/halls")
    public String halls(Model model) {
        model.addAttribute("halls", hallService.listHalls());
//        model.addAttribute("movieHall", new MovieHall());
        return "halls";
    }

//    @PostMapping("/addHall")
    @PostMapping("/admin/panel/halls")
    public String addhall(@ModelAttribute("hall") Hall hall){
        hallService.addHall(hall);
        return "redirect:/admin/panel/halls";
//        return "halls";
    }
}
