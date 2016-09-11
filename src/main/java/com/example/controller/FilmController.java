package com.example.controller;

import com.example.entity.Film;
import com.example.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aleksander
 */

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    FilmRepository filmRepository;

    @RequestMapping
    public List<Film> getPlays() {
        return filmRepository.findAll();
    }
}
