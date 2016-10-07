package com.example;

import com.example.assembler.ActorAssembler;
import com.example.controller.ActorController;
import com.example.entity.Actor;
import com.example.repository.*;
import com.example.resource.ActorResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.media.jfxmedia.Media;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Aleksander
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActorControllerTest{

    @Autowired
    TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void whenActorNotNullExpectActor() throws Exception {
        ResponseEntity<ActorResource> response =
                restTemplate.getForEntity("/actors/1", ActorResource.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void whenActorNullExpectActor() throws Exception {
        ResponseEntity<ActorResource> response =
                restTemplate.getForEntity("/actors/10", ActorResource.class);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


