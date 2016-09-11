package com.example.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author Aleksander
 */

@Getter
@RequiredArgsConstructor
public class IndexResource extends ResourceSupport {

    private final String name;
    private final String description;
}
