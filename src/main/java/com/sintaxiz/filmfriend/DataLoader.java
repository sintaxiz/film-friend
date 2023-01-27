package com.sintaxiz.filmfriend;

import com.sintaxiz.filmfriend.entity.Film;
import com.sintaxiz.filmfriend.entity.FilmType;
import com.sintaxiz.filmfriend.entity.Frame;
import com.sintaxiz.filmfriend.repositories.FilmRepository;
import com.sintaxiz.filmfriend.repositories.FilmTypeRepository;
import com.sintaxiz.filmfriend.repositories.FrameRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class DataLoader {
    private final FilmTypeRepository filmTypeRepository;
    private final FilmRepository filmRepository;
    private final FrameRepository frameRepository;

    public DataLoader(FilmTypeRepository filmTypeRepository, FilmRepository filmRepository, FrameRepository frameRepository) {
        this.filmTypeRepository = filmTypeRepository;
        this.filmRepository = filmRepository;
        this.frameRepository = frameRepository;
    }

    @PostConstruct
    private void loadData() {
        FilmType kodak = new FilmType("kodak", 200, true, "35mm", 36);
        FilmType fuji = new FilmType("fujifilm", 400, true, "35mm", 24);

        Film zenit = new Film("1", Instant.now(), 36, "zenit ttl", kodak);
        Film fed = new Film("2", Instant.now(), 24, "fed 5", fuji);

        filmTypeRepository.saveAll(List.of(kodak, fuji));
        filmRepository.saveAll(List.of(zenit, fed));
        frameRepository.save(new Frame("1", Instant.now(), null, "1", "1/60", "just photo1", "krasnoyarsk", zenit));
        frameRepository.save(new Frame("2", Instant.now(), null, "1", "1/60", "just photo2", "krasnoyarsk", zenit));
        frameRepository.save(new Frame("3", Instant.now(), null, "1", "1/60", "just photo3", "krasnoyarsk", fed));
        frameRepository.save(new Frame("4", Instant.now(), null, "1", "1/60", "just photo4", "krasnoyarsk", fed));
        frameRepository.save(new Frame("5", Instant.now(), null, "1", "1/60", "just photo5", "krasnoyarsk", zenit));
    }
}
