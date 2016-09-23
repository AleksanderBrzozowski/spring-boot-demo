package com.example.controller;

import com.example.assembler.ActorAssembler;
import com.example.assembler.ActorRoleAssembler;
import com.example.assembler.PictureAssembler;
import com.example.entity.Actor;
import com.example.entity.Picture;
import com.example.repository.ActorRepository;
import com.example.resource.ActorResource;
import com.example.resource.FilmRoleResource;
import com.example.resource.PictureResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aleksander
 */
@RequestMapping(value = "/actors")
@RestController
@ExposesResourceFor(ActorResource.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActorController {

    private final ActorRepository actorRepository;
    private final ActorAssembler actorAssembler;
    private final ActorRoleAssembler actorRoleAssembler;
    private final PictureAssembler pictureAssembler;

    @RequestMapping(method = RequestMethod.GET)
    public PagedResources<ActorResource> actors(Pageable pageable, PagedResourcesAssembler<Actor> pagedAssembler) {
        final Page<Actor> actors = actorRepository.findAll(pageable);
        return pagedAssembler.toResource(actors, actorAssembler);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ActorResource actor(@PathVariable int id) {
        final Actor actor = actorRepository.findOne(id);
        return actorAssembler.toResource(actor);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/filmography")
    public List<FilmRoleResource> filmography(@PathVariable int id) {
        final Actor actor = actorRepository.findOne(id);
        return actor.getFilms().entrySet().stream()
                .map(entry -> actorRoleAssembler.toResource(entry.getKey(), entry.getValue(), actor))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/pictures")
    public PagedResources<PictureResource> pictures(@PathVariable int id, Pageable pageable, PagedResourcesAssembler<Picture> pagedAssembler) {
        final List<Picture> pictures = new ArrayList<>(actorRepository.findOne(id).getPictures());
        return pagedAssembler.toResource(new PageImpl<>(pictures, pageable, pictures.size()), pictureAssembler);
    }
}
