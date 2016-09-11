package com.example.controller;

import com.example.assembler.ActorAssembler;
import com.example.entity.Actor;
import com.example.repository.ActorRepository;
import com.example.resource.ActorResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aleksander
 */
@RequestMapping("/actors")
@RestController
@ExposesResourceFor(ActorResource.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorController {

    private final ActorRepository actorRepository;
    private final ActorAssembler actorAssembler;

    @RequestMapping
    public PagedResources<ActorResource> actors(Pageable pageable, PagedResourcesAssembler<Actor> pagedAssembler) {
        final Page<Actor> actors = actorRepository.findAll(pageable);
        return pagedAssembler.toResource(actors, actorAssembler);
    }
}
