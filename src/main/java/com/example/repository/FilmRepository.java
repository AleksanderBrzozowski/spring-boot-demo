package com.example.repository;

import com.example.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aleksander
 */
public interface FilmRepository extends JpaRepository<Film, Integer> {
}
