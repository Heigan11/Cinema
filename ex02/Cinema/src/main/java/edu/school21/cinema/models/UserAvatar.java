package edu.school21.cinema.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "avatars")
public class UserAvatar {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "originalName")
    private String originalName;

    @Column(name = "uniqueName")
    private String uniqueName;

    @Column(name = "filepath")
    private String filepath;

    @Column(name = "imageSize")
    private Long size;

    @Column(name = "mimetype")
    private String mimetype;

    private String tableSize;
}
