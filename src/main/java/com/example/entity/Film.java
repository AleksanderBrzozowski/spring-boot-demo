package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

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
    private String mainPicture;
    @OneToMany(mappedBy = "film")
    private Set<ActorRole> roles = new HashSet<>();
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Set<Picture> pictures = new HashSet<>();


    public Film(String name, LocalDate releaseDate, Locale country, String mainPicture) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.country = country;
        this.mainPicture = mainPicture;
    }
}