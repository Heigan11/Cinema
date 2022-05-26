package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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

//        HttpSession session = req.getSession();
//        if (session.getAttribute("user") != null) {
//            User user = (User) session.getAttribute("user");
//            req.setAttribute("user", user);
//            req.setAttribute("userSessions", sessionService.getAllUserSession(user));
//            req.setAttribute("userImages", imageService.getAllUserImages(user));
//            session.setAttribute("image", imageService.getImageByUserId(user));
//            req.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(req, resp);
//        }

        return "profile";
    }
}
