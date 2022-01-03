package com.mycompany.dvdstore.entity;

import lombok.Data;

@Data
public class Movie {
    private final String title;
    private final String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
}
