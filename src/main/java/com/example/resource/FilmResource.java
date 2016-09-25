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
@Relation(value = "film", collectionRelation = "films")
@RequiredArgsConstructor
public class FilmResource extends ResourceSupport{

    private final String name;
    private final LocalDate releaseDate;
    private final String country;
    private final String picture;
}
