package com.example.tests.web;

import com.example.AbstractControllerTest;
import org.junit.Test;

/**
 * @author Aleksander
 */
public class FilmControllerTest extends AbstractControllerTest{

    @Test
    public void whenFilmNotNullExpectFilm() throws Exception {
        resourceFound("/films/1");
        resourceFound("/films/1/roles");
        resourceFound("/films/1/pictures");
    }

    @Test
    public void whenFilmNullExpectException() throws Exception {
        resourceNotFound("/films/7");
        resourceNotFound("/films/7/roles");
        resourceNotFound("/films/7/pictures");
    }
}
