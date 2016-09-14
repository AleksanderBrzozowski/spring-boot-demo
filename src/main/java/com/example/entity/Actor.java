package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import java.time.LocalDate;
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
    private LocalDate dateOfBirth;

    @ManyToMany(mappedBy = "actors")
    @MapKeyJoinColumn(name = "actor_role_id")
    private Map<ActorRole, Film> films = new HashMap<>();

    public Actor(String name, LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }
}
