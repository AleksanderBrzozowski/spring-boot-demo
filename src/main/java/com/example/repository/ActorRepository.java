package com.example.repository;

import com.example.entity.Actor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by aleksander on 09.09.16.
 */
public interface ActorRepository extends PagingAndSortingRepository<Actor, Integer> {
}
