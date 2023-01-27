package com.sintaxiz.filmfriend.api;

import com.sintaxiz.filmfriend.entity.Frame;
import com.sintaxiz.filmfriend.repositories.FrameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/frames")
public class FramesApi {
    private final FrameRepository frameRepository;

    public FramesApi(FrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }

    @GetMapping
    Iterable<Frame> getFrames() {
        return frameRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Frame> getFrameById(@PathVariable String id) {
        return frameRepository.findById(id);
    }

    @PostMapping
    Frame addFrame(@RequestBody Frame Frame) {
        return frameRepository.save(Frame);
    }

    @PutMapping("/{id}")
    ResponseEntity<Frame> changeFrame(@PathVariable String id, @RequestBody Frame frame) {
        HttpStatus httpStatus;
        if (frameRepository.existsById(id)) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }
        var newFrame = frameRepository.save(frame);
        return new ResponseEntity<>(newFrame, httpStatus);

    }

    @DeleteMapping("/{id}")
    void deleteFrame(@PathVariable String id) {
        frameRepository.deleteById(id);
    }
}
