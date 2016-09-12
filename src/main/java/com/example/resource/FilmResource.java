package com.example.resource;

import com.example.entity.Actor;
import com.example.entity.ActorRole;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

/**
 * @author Aleksander
 */

@Getter
@Relation(value = "film", collectionRelation = "films")
public class FilmResource extends ResourceSupport{

    private String name;
    private ActorRole actorRole;
    private Actor actor;

    public FilmResource(String name, ActorRole actorRole, Actor actor) {
        this.name = name;
        this.actorRole = actorRole;
        this.actor = actor;
    }

    public FilmResource(String name, ActorRole actorRole) {
        this.name = name;
        this.actorRole = actorRole;
    }
}
