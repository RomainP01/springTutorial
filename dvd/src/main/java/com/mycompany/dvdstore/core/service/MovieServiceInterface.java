package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieServiceInterface {
    Movie registerMovie(Movie movie);

    Iterable<Movie> getMovieList();
    Optional<Movie> getMovieById(long id);
}
