package com.example.controller;

import com.example.assembler.ActorAssembler;
import com.example.assembler.PictureAssembler;
import com.example.entity.Picture;
import com.example.repository.PictureRepository;
import com.example.resource.ActorResource;
import com.example.resource.FilmResource;
import com.example.resource.PictureResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aleksander
 */

@ExposesResourceFor(Picture.class)
@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PictureController {

    private final PictureRepository pictureRepository;
    private final PictureAssembler pictureAssembler;
    private final ActorAssembler actorAssembler;

    @RequestMapping(method = RequestMethod.GET)
    public List<PictureResource> pictures() {
        return pictureRepository.findAll().stream()
                .map(pictureAssembler::toResource)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public PictureResource picture(@PathVariable String id) {
        return pictureAssembler.toResource(pictureRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/actors")
    public List<ActorResource> actors(@PathVariable String id) {
        return pictureRepository.findOne(id).getActorsSet().stream()
                .map(actorAssembler::toResource)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/film")
    public FilmResource film(@PathVariable String id) {
        return null;
    }
}
