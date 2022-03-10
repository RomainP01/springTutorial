package com.mycompany.dvdstore.core.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
