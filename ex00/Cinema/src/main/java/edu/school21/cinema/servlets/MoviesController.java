package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Movie;
import edu.school21.cinema.services.MovieService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Controller
public class MoviesController {

    private final MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/admin/panel/films")
    public String Movies(Model model) {
//        Path currentRelativePath = Paths.get("");
//        String s = currentRelativePath.toAbsolutePath().toString();
//        System.out.println("Current absolute path is: " + s);
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        File img = new File("images/no-img.jpg");
        model.addAttribute("movies", movieService.listMovies());
        return "films";
    }

    @GetMapping("/admin/panel/films/image/{id}")
    @ResponseBody
    public byte[] getContent(@PathVariable("id") Long id) {
        try {
            Movie movie = movieService.getMovieById(id);
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toRealPath().toString();
            if (movie.getPosterUrl() == null)
                return FileUtils.readFileToByteArray(new File(s + "/src/main/webapp/images/no-img.jpg"));
            return FileUtils.readFileToByteArray(new File(s + movie.getPosterUrl()));
        } catch (IOException e) {
            return null;
        }
    }

    @GetMapping("/admin/panel/films/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.removeMovie(id);
        return "redirect:/admin/panel/films";
    }

//    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
//    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
//        modelMap.addAttribute("file", file);
//        return "fileUploadView";
//    }

    @PostMapping("/admin/panel/films/addPoster/{id}")
    public String addPoster(@RequestParam("file") MultipartFile file,
                            @PathVariable("id") Long id) throws IOException {
        System.out.println("Updated movie: " + movieService.getMovieById(id));

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toRealPath().toString();

        String dirPath =  s + "/src/main/webapp/images/" + id + "/";

        File f = new File(dirPath);

        if (!f.exists())
            f.mkdir();

        for (File myFile : f.listFiles())
            if (myFile.isFile())
                myFile.delete();

        System.out.println(file.getContentType());
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());

//        File poster = new File(dirPath + file.getOriginalFilename());
//            poster.createNewFile();

//       file.transferTo(poster);

       Path path = Paths.get(dirPath + file.getOriginalFilename());
       file.transferTo(path);

//        movieService.updateMovie(movie);
        return "redirect:/admin/panel/films";
    }

    @PostMapping("/admin/panel/films")
    public String addMovie(@ModelAttribute("movie") Movie movie){
        movieService.addMovie(movie);
        return "redirect:/admin/panel/films";
    }
}
