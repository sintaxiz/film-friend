package com.sintaxiz.filmfriend.repositories;

import com.sintaxiz.filmfriend.entity.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, String> {
}
