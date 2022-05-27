package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.ImageService;
import edu.school21.cinema.services.UserService;
import edu.school21.cinema.services.UserSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class ProfileController {

    private final UserService userService;
    private final UserSessionService userSessionService;
    private final ImageService imageService;

    @GetMapping("/admin/panel/profile")
    public String profile(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        model.addAttribute("usersessions", userSessionService.getAllUserSession(user));
        model.addAttribute("user", user);
        model.addAttribute("image", imageService.getImageByUserId(user));
        model.addAttribute("images", imageService.getAllUserImages(user));

        return "profile";
    }
}
