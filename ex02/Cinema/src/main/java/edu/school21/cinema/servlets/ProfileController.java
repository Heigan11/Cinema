package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ProfileController {

    @GetMapping("/admin/panel/profile")
    public String profile(Model model) {
//        model.addAttribute("halls", hallService.listHalls());
        //TODO addAttribute user
        // list of sessions
        // list of uploaded avatars
        // current avatar
        return "profile";
    }
}
