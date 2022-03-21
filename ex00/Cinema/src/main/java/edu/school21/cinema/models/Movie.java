package edu.school21.cinema.models;

import lombok.*;
import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int yearOfRelease;

    @Column(name = "restriction")
    private int ageRestrictions;

    @Column(name = "description")
    private String description;

    @Column(name = "poster")
    private String posterUrl;

//    public Movie() throws IOException {
//        Path currentRelativePath = Paths.get("");
//        String s = currentRelativePath.toRealPath().toString();
//        File img = new File(s + "/src/main/webapp/images/no-img.jpg");
//        byte[] fileContent = FileUtils.readFileToByteArray(img);
//        String encodedString = Base64.getEncoder().encodeToString(fileContent);
//
//        this.posterUrl = encodedString;
//    }
//
//    public Movie(String title, int yearOfRelease, int ageRestrictions, String description) throws IOException {
//        this.title = title;
//        this.yearOfRelease = yearOfRelease;
//        this.ageRestrictions = ageRestrictions;
//        this.description = description;
//
//        File img = new File("/images/no-img.jpg");
//        byte[] fileContent = FileUtils.readFileToByteArray(img);
//        String encodedString = Base64.getEncoder().encodeToString(fileContent);
//
//        this.posterUrl = encodedString;
//    }
}
