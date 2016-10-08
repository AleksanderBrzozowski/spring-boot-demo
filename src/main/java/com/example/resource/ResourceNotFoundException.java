package com.example.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author Aleksander
 */

@AllArgsConstructor
@Getter
public class ResourceNotFoundException {

    private final String message;
    private final LocalDateTime timestamp;
    private final String path;
}
