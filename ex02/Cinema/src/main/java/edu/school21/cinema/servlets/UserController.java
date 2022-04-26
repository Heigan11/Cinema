package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.SessionService;
import edu.school21.cinema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;


    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String registerUser(@ModelAttribute("user") User user) {

        String tempPassword = user.getPassword();
        user.setPassword(passwordEncoder.encode(tempPassword));
        userService.saveUser(user);
        return "redirect:/signUp";
    }

}
