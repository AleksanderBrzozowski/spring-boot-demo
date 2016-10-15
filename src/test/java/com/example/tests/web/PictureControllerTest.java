package com.example.tests.web;

import com.example.AbstractControllerTest;
import org.junit.Test;

/**
 * @author Aleksander
 */
public class PictureControllerTest extends AbstractControllerTest{

    @Test
    public void whenPictureNotNullExpectPicture() throws Exception {
        resourceFound("/pictures/pic");
        resourceFound("/pictures/pic/actors");
        resourceFound("/pictures/pic/film");
    }

    @Test
    public void whenPictureNullExpectException() throws Exception {
        resourceNotFound("/pictures/7");
        resourceNotFound("/pictures/7/actors");
        resourceNotFound("/pictures/7/film");
    }
}
