package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.SessionService;
import edu.school21.cinema.services.UserService;
import edu.school21.cinema.services.UserSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserSessionService userSessionService;


    @GetMapping("/signUp/{id}")
    public String getSignUpPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("film_id", id);
        return "signUp";
    }

    @PostMapping("/signUp/{film_id}")
    public String registerUser(@ModelAttribute("user") User user,@PathVariable("film_id") Long film_id, HttpServletRequest req) {

        String tempPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(tempPassword));
        user.setAvatarId(1L);
        userService.saveUser(user);

        return "redirect:/admin/panel/films";
//        if (userService.isUser(user)) {
//            HttpSession session = req.getSession();
//            session.setAttribute("user", userService.getUserByName(user.getName()).get(0));
//            return "redirect:/films/" + film_id + "/chat";
//        }
//        return "redirect:/signUp/" + film_id;
    }

    @GetMapping("/signIn/{id}")
    public String getSignInPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "signIn";
    }

    @PostMapping("/signIn/{id}")
    public String loginUser(@ModelAttribute("user") User user, @PathVariable("id") Long id, HttpServletRequest req) {
        if (userService.isUser(user)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", userService.getUserByName(user.getName()).get(0));
            userSessionService.saveSession(user, req.getRemoteAddr());

//            return "redirect:/admin/panel/films";
            return "redirect:/films/" + id + "/chat";
        }
        return "redirect:/signIn/" + id;
    }
}
