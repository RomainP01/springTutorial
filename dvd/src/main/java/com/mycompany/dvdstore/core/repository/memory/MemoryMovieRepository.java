package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryMovieRepository implements MovieRepositoryInterface {
    private static final List<Movie> movies = new ArrayList<>();
    public static long lastId=0L;
    @Override
    public Movie save(Movie movie){
        movie.setId(lastId++);
        movies.add(movie);
        System.out.println("The movie "+movie.getTitle()+" has been added.");
        return movie;
    }

    @Override
    public Iterable<Movie> findAll() {
        return movies;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movies.stream().
                filter(m -> m.getId()==id).
                findFirst();
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Movie movie) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Movie> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }
}
