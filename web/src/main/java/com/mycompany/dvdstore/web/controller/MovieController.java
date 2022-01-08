package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

public class MovieController implements MovieControllerInterface {
    @Autowired
    MovieServiceInterface movieService;

    @Override
    public List<Movie> displayHome() {
        return null;
    }

    public void addUsingConsole(){

        System.out.println("Name of the movie ? ");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        System.out.println("Genre of the movie");
        String genre = sc.nextLine();
        Movie movie = new Movie(title,genre);
        movieService.registerMovie(movie);
    }

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }
}
