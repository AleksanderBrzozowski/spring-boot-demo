package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by aleksander on 09.09.16.
 */
public class Actor {

    private int id;
    private String name;
    private Set<Play> plays;

    public Actor() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn
    public Set<Play> getPlays() {
        return plays;
    }
}
