package com.mycompany.dvdstore.core.entity;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String title;
    private String genre;
    private String description;

    public Movie(Long id, String title, String genre, String description) {
        this.title = title;
        this.genre = genre;
        this.id = id;
        this.description = description;
    }
    public Movie(Long id, String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.id = id;
    }

    public Movie() {

    }
}
