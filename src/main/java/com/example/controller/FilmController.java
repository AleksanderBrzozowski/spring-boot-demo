package com.example.controller;

import com.example.assembler.ActorRoleAssembler;
import com.example.assembler.FilmAssembler;
import com.example.assembler.PictureAssembler;
import com.example.entity.ActorRole;
import com.example.entity.Film;
import com.example.entity.Picture;
import com.example.repository.FilmRepository;
import com.example.resource.ActorRoleResource;
import com.example.resource.FilmResource;
import com.example.resource.PictureResource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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

/**
 * @author Aleksander
 */

@RestController
@RequestMapping("/films")
@ExposesResourceFor(Film.class)
@RequiredArgsConstructor
public class FilmController {

    @NonNull private final FilmRepository filmRepository;
    @NonNull private final FilmAssembler filmAssembler;
    @NonNull private final PictureAssembler pictureAssembler;
    @NonNull private final ActorRoleAssembler actorRoleAssembler;

    @RequestMapping(method = RequestMethod.GET)
    public PagedResources<FilmResource> films(Pageable pageable, PagedResourcesAssembler<Film> assembler) {
        final Page<Film> page = filmRepository.findAll(pageable);
        return assembler.toResource(page, filmAssembler);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public FilmResource film(@PathVariable int id) {
        final Film film = filmRepository.findOne(id);
        return filmAssembler.toResource(film);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/roles")
    public PagedResources<ActorRoleResource> roles(@PathVariable int id, Pageable pageable, PagedResourcesAssembler<ActorRole> assembler) {
        final List<ActorRole> roles = new ArrayList<>(filmRepository.findOne(id).getRoles());
        return assembler.toResource(new PageImpl<>(roles, pageable, roles.size()), actorRoleAssembler);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/pictures")
    public PagedResources<PictureResource> pictures(@PathVariable int id, Pageable pageable, PagedResourcesAssembler<Picture> assembler) {
        final List<Picture> pictures = new ArrayList<>(filmRepository.findOne(id).getPictures());
        return assembler.toResource(new PageImpl<>(pictures, pageable, pictures.size()), pictureAssembler);
    }
}
