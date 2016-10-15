package com.example;

import com.example.entity.Actor;
import com.example.resource.ActorResource;
import com.example.resource.ResourceNotFoundException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Aleksander
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class AbstractControllerTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    protected TestRestTemplate restTemplate;

    protected void resourceNotFound(String path) {
        ResponseEntity<ResourceNotFoundException> response =
                restTemplate.getForEntity(path, ResourceNotFoundException.class);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
        assertEquals(response.getBody().getPath(), path);
    }

    protected void resourceFound(String path) {
        ResponseEntity<ResourceSupport> response = restTemplate.getForEntity(path, ResourceSupport.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertFalse(response.getBody().getLinks().isEmpty());
    }
}
