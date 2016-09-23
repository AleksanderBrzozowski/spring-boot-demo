package com.example.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.util.List;
import java.util.Set;

/**
 * @author aleksander
 */

@RequiredArgsConstructor
@Getter
@Relation(value = "picture", collectionRelation = "pictures")
public class PictureResource extends ResourceSupport{

    private final String url;
}
