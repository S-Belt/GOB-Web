package gob.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity                     // On indique à Spring de considérer cette classe comme une entité
@Table(name = "USER")       // Ici, on nomme notre table

@Getter                     // Block Lombok : Getters, Setters et Les Constructeurs
@Setter
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String username;
    private String password;
    private Boolean loggedIn;
    private Boolean active;
    @CreationTimestamp
    private LocalDate creationDate;
    @CreationTimestamp
    private LocalDate lastConnexion;

    public User(Long user_id, String username, String password, Boolean loggedIn, Boolean active, LocalDate user_creationDate, LocalDate user_lastConnexion) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.loggedIn = true;
        this.active = true;
        this.creationDate = LocalDate.now();
        this.lastConnexion = null;
    }
}
