package com.example.controller;

import com.example.assembler.IndexAssembler;
import com.example.resource.IndexResource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aleksander
 */

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {

    @NonNull private final IndexAssembler indexAssembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<IndexResource> index() {
        return ResponseEntity.ok(indexAssembler.buildIndex());
    }

}
