package com.example.repository;

import com.example.entity.Film;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Aleksander
 */
public interface FilmRepository extends PagingAndSortingRepository<Film, Integer> {
}
