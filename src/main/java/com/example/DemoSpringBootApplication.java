package com.example;

import com.example.repository.ActorRepository;
import com.example.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBootApplication {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private PlayRepository playRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);

	}
}
