package com.example.entity;

import java.util.Set;

/**
 * Created by aleksander on 09.09.16.
 */
public class Play {

    private int id;
    private String name;
    private Set<Actor> actors;

    public Play() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Actor> getActors() {
        return actors;
    }
}
