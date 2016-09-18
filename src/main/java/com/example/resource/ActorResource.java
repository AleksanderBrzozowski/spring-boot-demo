package com.example.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.time.LocalDate;


/**
 * @author Aleksander
 */

@Getter
@RequiredArgsConstructor
@Relation(value = "actor", collectionRelation = "actors")
public class ActorResource extends ResourceSupport{

    private final String name;
    private final LocalDate dateOfBirth;
    private final String country;

}
