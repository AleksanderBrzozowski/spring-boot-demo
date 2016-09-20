package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import java.time.LocalDate;
import java.util.*;

/**
 * @author Aleksander
 */
@NoArgsConstructor
@Getter
@Entity
public class Actor extends AbstractEntity<Integer>{

    private String name;
    private LocalDate dateOfBirth;
    private Locale country;
    private String mainPicture;
    @ManyToMany(mappedBy = "actorsSet")
    private Set<Picture> pictures = new HashSet<>();

    @ManyToMany(mappedBy = "actors")
    @MapKeyJoinColumn(name = "actor_role_id")
    private Map<ActorRole, Film> films = new HashMap<>();

    public Actor(String name, LocalDate dateOfBirth, Locale country, String mainPicture) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.country = country;
        this.mainPicture = mainPicture;
    }
}
