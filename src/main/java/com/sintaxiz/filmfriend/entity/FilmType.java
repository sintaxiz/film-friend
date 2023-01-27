package com.sintaxiz.filmfriend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmType {
    @Id
    private String id;
    private String name;
    private int iso;
    private boolean isColor;
    private String format;
    private int defaultExposures;

    public FilmType(String name, int iso, boolean isColor, String format, int defaultExposures) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.iso = iso;
        this.isColor = isColor;
        this.format = format;
        this.defaultExposures = defaultExposures;
    }
}
