package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.models.UserAvatar;
import edu.school21.cinema.repositories.UserAvatarRepository;
import edu.school21.cinema.repositories.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

public class ImageService {

    private final UserAvatarRepository userAvatarRepository;
    private final UserService userService;

    public ImageService(UserAvatarRepository userAvatarRepository, UserService userService) {
        this.userAvatarRepository = userAvatarRepository;
        this.userService = userService;
    }

    public List<UserAvatar> getAllUserImages(User user) {
        return userAvatarRepository.findAllByUserId(user.getId());
    }

    public UserAvatar saveImage(UserAvatar userAvatar) {
        return userAvatarRepository.save(userAvatar);
    }

    public UserAvatar saveImage(HttpServletRequest req, Long userid) throws ServletException, IOException {
        Path pathProject = Files.createDirectories(Paths.get("src/main/webapp/images/" + userid));
        Path pathContainer = Files.createDirectories(Paths.get("target/cargo/configurations/tomcat9x/webapps/images/" + userid));
        Part filePart = req.getPart("file");

        String fileName = filePart.getSubmittedFileName();
        String type = filePart.getContentType();
        long size = filePart.getSize();
        String uniqueName = UUID.randomUUID() + "_" + fileName;
        if (type.equals("image/png") || type.equals("image/jpeg")) {
            for (Part part : req.getParts()) {
                part.write(pathContainer.toAbsolutePath() + "/" + uniqueName);
            }
            Path copied = Paths.get(pathProject.toAbsolutePath() + "/" + uniqueName);
            Path originalPath = Paths.get(pathContainer.toAbsolutePath() + "/" + uniqueName);
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);

            User user = userService.findUserById(userid);
            UserAvatar image = new UserAvatar(null, user, fileName, uniqueName, pathContainer.toAbsolutePath() + "/" + uniqueName, size, type);
            return saveImage(image);
        }
        return null;
    }

    public UserAvatar getImageByUserId(User user) {
        return userAvatarRepository.findById(user.getAvatarId());
    }
}
