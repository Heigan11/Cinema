package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;

import javax.servlet.http.HttpSession;

public class ImageController {

//    HttpSession session = req.getSession();
//    User user = (User) session.getAttribute("user");
//        if (req.getParameter("img") != null && user != null) {
//        long imageId = Long.parseLong(req.getParameter("img"));
//        user.setAvatar(imageId);
//        userService.updateUser(user);
//    }
//        resp.sendRedirect("/profile");

//UPLOAD --->
//    HttpSession session = req.getSession();
//        if (session.getAttribute("user") != null) {
//        User user = (User) session.getAttribute("user");
//        Image image = imageService.saveImage(req, user.getId());
//        if (image == null) {
//            resp.sendRedirect("/profile");
//            return;
//        }
//        user.setAvatar(image.getId());
//        userService.updateUser(user);
//        session.setAttribute("image", image);
//    }
//        resp.sendRedirect("/profile");
}
