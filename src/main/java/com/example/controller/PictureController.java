package com.example.controller;

import com.example.assembler.ActorAssembler;
import com.example.assembler.FilmAssembler;
import com.example.assembler.PictureAssembler;
import com.example.entity.Actor;
import com.example.entity.Film;
import com.example.entity.Picture;
import com.example.repository.PictureRepository;
import com.example.resource.ActorResource;
import com.example.resource.FilmResource;
import com.example.resource.PictureResource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author aleksander
 */

@ExposesResourceFor(Picture.class)
@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PictureController {

    private @NonNull final PictureRepository pictureRepository;
    private @NonNull final PictureAssembler pictureAssembler;
    private @NonNull final ActorAssembler actorAssembler;
    private @NonNull final FilmAssembler filmAssembler;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public PictureResource picture(@PathVariable String id) {
        final Picture picture = pictureRepository.findOne(id);
        return pictureAssembler.toResource(picture);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/actors")
    public PagedResources<ActorResource> actors(@PathVariable String id, Pageable pageable, PagedResourcesAssembler<Actor> assembler) {
        List<Actor> actors = new ArrayList<>(pictureRepository.findOne(id).getActorsSet());
        return assembler.toResource(new PageImpl<>(actors, pageable, actors.size()), actorAssembler);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/film")
    public FilmResource film(@PathVariable String id) {
        final Film film = pictureRepository.findOne(id).getFilm();
        return filmAssembler.toResource(film);
    }
}
