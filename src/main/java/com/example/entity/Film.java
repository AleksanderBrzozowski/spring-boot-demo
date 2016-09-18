package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @MapKeyJoinColumn(name = "actor_role_id")
    private Map<ActorRole, Actor> actors = new HashMap<>();

    public Film(String name) {
        this.name = name;
    }

    public Film(String name, LocalDate releaseDate, Locale country) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.country = country;
    }
}