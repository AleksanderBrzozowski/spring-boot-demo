package com.example.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Aleksander
 */

@EqualsAndHashCode(of = "url")
@NoArgsConstructor
@Getter
@Entity
public class Picture implements Identifiable<String>{

    @Id
    private String url;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "picture_actors", joinColumns = @JoinColumn(name = "picture_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actorsSet = new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Film film;

    public Picture(String url, Film film) {
        this.url = url;
        this.film = film;
    }

    @Override
    public String getId() {
        return url;
    }
}
