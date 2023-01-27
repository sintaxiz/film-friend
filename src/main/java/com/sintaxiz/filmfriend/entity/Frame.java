package com.sintaxiz.filmfriend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Frame {
    @Id
    private String id;

    private Instant shotDate;
    private String imagePath;
    private String diaphragm;
    private String excerpt;
    private String description;
    private String place;

    @ManyToOne
    private Film film;
}
