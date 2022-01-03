package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MemoryMovieRepository implements MovieRepositoryInterface {
    private static final List<Movie> movies = new ArrayList<>();
    public void add(Movie movie){
        movies.add(movie);
        System.out.println("movie "+movie.getTitle()+" has been added");
    }
}
