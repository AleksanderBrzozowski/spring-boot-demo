package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by aleksander on 09.09.16.
 */
@NoArgsConstructor
@Entity
@Getter
public class Actor extends AbstractEntity<Integer>{

    private String name;
    @ManyToMany(mappedBy = "actors")
    private Set<Play> plays = new HashSet<>();

    public Actor(String name) {
        this.name = name;
    }
}
