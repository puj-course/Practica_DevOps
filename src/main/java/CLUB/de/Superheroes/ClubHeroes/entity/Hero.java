package CLUB.de.Superheroes.ClubHeroes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String powers;
    private String origin;

    @Column(nullable = false)
    private int level; // 1 a 5 (1 es el más alto)

    private String secretIdentity;

    @ManyToMany(mappedBy = "heroes")
    private Set<Mission> missions;
}
