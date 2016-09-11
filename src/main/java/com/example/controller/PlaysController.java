package com.example.controller;

import com.example.entity.Play;
import com.example.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by aleksander on 09.09.16.
 */

@RestController
@RequestMapping("/plays")
public class PlaysController {

    @Autowired
    PlayRepository playRepository;

    @RequestMapping
    public List<Play> getPlays() {
        return playRepository.findAll();
    }
}
