package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksander
 */
@NoArgsConstructor
@Getter
@Entity
public class Actor extends AbstractEntity<Integer>{

    private String name;
    @ManyToMany(mappedBy = "actors")
    @MapKey
    private Map<ActorRole, Film> films = new HashMap<>();

    public Actor(String name) {
        this.name = name;
    }
}
