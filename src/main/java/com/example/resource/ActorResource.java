package com.example.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;


/**
 * Created by Aleksander on 2016-09-10.
 */

@Getter
@RequiredArgsConstructor
@Relation(value = "actor", collectionRelation = "actors")
public class ActorResource extends ResourceSupport{

    private final String name;

}
