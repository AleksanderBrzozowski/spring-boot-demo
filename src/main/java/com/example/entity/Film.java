package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksander
 */

@Getter
@NoArgsConstructor
@Entity
public class Film extends AbstractEntity<Integer>{

    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @MapKeyJoinColumn(name = "actor_role_id")
    private Map<ActorRole, Actor> actors = new HashMap<>();

    public Film(String name) {
        this.name = name;
    }
}