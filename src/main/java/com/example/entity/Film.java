package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * @author Aleksander
 */

@Getter
@NoArgsConstructor
@Entity
public class Film extends AbstractEntity<Integer>{

    private String name;
    private LocalDate releaseDate;
    private Locale country;
    private String picture;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles_map",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @MapKeyJoinColumn(name = "actor_role_id")
    private Map<ActorRole, Actor> actors = new HashMap<>();
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Set<Picture> pictures = new HashSet<>();


    public Film(String name, LocalDate releaseDate, Locale country) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.country = country;
    }
}