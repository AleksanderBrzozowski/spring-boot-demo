package com.example.resource;

import com.example.entity.Actor;
import com.example.entity.ActorRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

/**
 * @author Aleksander
 */

@Getter
@Relation(value = "film", collectionRelation = "films")
@RequiredArgsConstructor
public class FilmResource extends ResourceSupport{

    private final String name;
    private final ActorRole actorRole;
    private final Actor actor;
}
