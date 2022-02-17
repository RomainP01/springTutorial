package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class MemoryMovieRepository implements MovieRepositoryInterface {
    private static final List<Movie> movies = new ArrayList<>();
    public static long lastId=0L;
    public void add(Movie movie){
        movie.setId(lastId++);
        movies.add(movie);
        System.out.println("movie "+movie.getTitle()+" has been added");
    }

    @Override
    public List<Movie> list() {
        return null;
    }

    @Override
    public Movie getById(long id) {
        return movies.stream().
                filter(m -> m.getId()==id).
                findFirst().get();
    }
}
