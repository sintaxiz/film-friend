package com.sintaxiz.filmfriend.api;

import com.sintaxiz.filmfriend.entity.Film;
import com.sintaxiz.filmfriend.repositories.FilmRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmsApi {
    private final FilmRepository filmRepository;

    public FilmsApi(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping
    Iterable<Film> getFilmTypes() {
        return filmRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Film> getFilmTypeById(@PathVariable String id) {
        return filmRepository.findById(id);
    }

    @PostMapping
    Film addFilmType(@RequestBody Film filmType) {
        return filmRepository.save(filmType);
    }

    @PutMapping("/{id}")
    ResponseEntity<Film> changeFilmType(@PathVariable String id, @RequestBody Film filmType) {
        HttpStatus httpStatus;
        if (filmRepository.existsById(id)) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }
        var newFilmType = filmRepository.save(filmType);
        return new ResponseEntity<>(newFilmType, httpStatus);

    }

    @DeleteMapping("/{id}")
    void deleteFilmType(@PathVariable String id) {
        filmRepository.deleteById(id);
    }
}
