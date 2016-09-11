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
@Relation(value = "actor", collectionRelation = "actors")
public class ActorResource extends ResourceSupport{

    private final String name;

}
