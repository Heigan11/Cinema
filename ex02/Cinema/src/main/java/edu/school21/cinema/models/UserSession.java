package edu.school21.cinema.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "sessionuser")
public class UserSession {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(name = "sessionDate")
    private LocalDate date;

    @Column(name = "sessionTime")
    private LocalTime time;

    @Column(name = "ip")
    private String ip;

    private String tableDate;
    private String tableTime;
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    private static final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
}
