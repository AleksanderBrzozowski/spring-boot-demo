package com.example.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

/**
 * @author Aleksander
 */

@Getter
@RequiredArgsConstructor
@Relation(value = "role", collectionRelation = "roles")
public class ActorRoleResource extends ResourceSupport {

    private final String nameInFilm;
    private final float stars;
    private final int votes;
    private final String picture;
}
