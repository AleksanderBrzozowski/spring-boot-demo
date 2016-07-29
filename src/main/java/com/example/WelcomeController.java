package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by aleksander on 29.07.16.
 */

@Controller
@RequestMapping("/home")
public class WelcomeController {

    @RequestMapping
    @ResponseBody
    public Message message() {
        return new Message("Hello World");
    }
}
