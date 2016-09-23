package com.example.controller;

import com.example.entity.Film;
import com.example.repository.FilmRepository;
import com.example.resource.FilmResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aleksander
 */

@RestController
@RequestMapping("/films")
@ExposesResourceFor(FilmResource.class)
public class FilmController {

    @Autowired
    FilmRepository filmRepository;

    @RequestMapping
    public List<Film> getPlays() {
        final List<Film> films = filmRepository.findAll();
        return films;
    }

    @RequestMapping("/{id}")
    public FilmResource film(@PathVariable int id) {
        return null;
    }
}
