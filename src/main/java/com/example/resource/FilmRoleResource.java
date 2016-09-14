package com.example.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

/**
 * Created by aleksander on 12.09.16.
 */

@Getter
@RequiredArgsConstructor
@Relation(value = "role", collectionRelation = "filmography")
public class FilmRoleResource extends ResourceSupport {

    private final String playName;
    private final String nameInFilm;
    private final float stars;
}
