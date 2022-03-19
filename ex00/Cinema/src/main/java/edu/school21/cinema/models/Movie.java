package edu.school21.cinema.models;

import lombok.*;
import javax.persistence.*;

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
}
