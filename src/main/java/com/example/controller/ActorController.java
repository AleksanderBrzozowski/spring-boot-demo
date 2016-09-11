package com.example.controller;

import com.example.assembler.ActorAssembler;
import com.example.entity.Actor;
import com.example.repository.ActorRepository;
import com.example.resource.ActorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Aleksander on 2016-09-10.
 */
@RequestMapping("/actors")
@RestController
@ExposesResourceFor(ActorResource.class)
public class ActorController {

    @Autowired
    ActorRepository actorRepository;
    @Autowired
    ActorAssembler actorAssembler;

    @RequestMapping
    public ResponseEntity<?> getActors() {
        return new ResponseEntity<Object>(actorRepository.findAll().stream().map(actor -> actorAssembler.toResource(actor)).toArray(), HttpStatus.OK);
    }
}
