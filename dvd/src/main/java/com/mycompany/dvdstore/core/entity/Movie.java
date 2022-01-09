package com.mycompany.dvdstore.core.entity;


import lombok.Data;

@Data
public class Movie {
    private final String title;
    private final String genre;
    private final Long id;
    private final String description;

    public Movie(String title, String genre, Long id, String description) {
        this.title = title;
        this.genre = genre;
        this.id = id;
        this.description = description;
    }
}
