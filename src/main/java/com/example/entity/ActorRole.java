package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Aleksander
 */

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ActorRole extends AbstractEntity<Integer>{

    private String nameInFilm;
    @OneToOne
    private Rating rating;
}
