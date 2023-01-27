package com.sintaxiz.filmfriend.api;

import com.sintaxiz.filmfriend.entity.FilmType;
import com.sintaxiz.filmfriend.repositories.FilmTypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/film-types")
public class FilmTypesApi {

    private final FilmTypeRepository filmTypeRepository;

    public FilmTypesApi(FilmTypeRepository filmTypeRepository) {
        this.filmTypeRepository = filmTypeRepository;
    }

    @GetMapping
    Iterable<FilmType> getFilmTypes() {
        return filmTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<FilmType> getFilmTypeById(@PathVariable String id) {
        return filmTypeRepository.findById(id);
    }

    @PostMapping
    FilmType addFilmType(@RequestBody FilmType filmType) {
        return filmTypeRepository.save(filmType);
    }

    @PutMapping("/{id}")
    ResponseEntity<FilmType> changeFilmType(@PathVariable String id, @RequestBody FilmType filmType) {
        HttpStatus httpStatus;
        if (filmTypeRepository.existsById(id)) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }
        var newFilmType = filmTypeRepository.save(filmType);
        return new ResponseEntity<>(newFilmType, httpStatus);

    }

    @DeleteMapping("/{id}")
    void deleteFilmType(@PathVariable String id) {
        filmTypeRepository.deleteById(id);
    }
}
