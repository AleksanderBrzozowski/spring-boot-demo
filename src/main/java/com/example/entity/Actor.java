package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Aleksander
 */
@NoArgsConstructor
@Entity
@Getter
public class Actor extends AbstractEntity<Integer>{

    private String name;
    @ManyToMany(mappedBy = "actors")
    private Set<Film> films = new HashSet<>();

    public Actor(String name) {
        this.name = name;
    }
}
