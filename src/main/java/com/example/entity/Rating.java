package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author Aleksander
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Rating extends AbstractEntity<Integer>{

    private int sumOfVotes;
    private float stars;
}
