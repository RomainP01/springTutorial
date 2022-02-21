package com.mycompany.dvdstore.api;

import com.mycompany.dvdstore.core.controller.MovieControllerInterface;
import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import com.mycompany.dvdstore.entitiy.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/movie")
@RestController
public class MovieResource implements MovieControllerInterface {
    @Autowired
    MovieServiceInterface movieService;

    @Override
    public List<Movie> displayHome() {
        return null;
    }


    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }


    @GetMapping("")
    public @ModelAttribute("movies") List<Movie> list(){
        return movieService.getMovieList();
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") Long id){
        return movieService.getMovieById(id);
    };

    @PostMapping("/add")
    public Movie add(@RequestBody Movie movie, BindingResult result){
        return movieService.registerMovie(movie);
    }
}
