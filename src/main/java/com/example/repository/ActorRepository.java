package com.example.repository;

import com.example.entity.Actor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Aleksander
 */
public interface ActorRepository extends PagingAndSortingRepository<Actor, Integer> {
}
