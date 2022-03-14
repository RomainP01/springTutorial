package com.mycompany.dvdstore.web.controller;

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
@Controller
public class MovieController implements MovieControllerInterface {
    @Autowired
    MovieServiceInterface movieService;

    @Override
    public void displayHome() {
    }


    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    /*@GetMapping("/{id}")
    public ModelAndView displayMovieCard(@PathVariable("id") Long id){
        System.out.println("movie details"+id);
        ModelAndView mv = new ModelAndView("movie-details");
        mv.addObject("movie",movieService.getMovieById(id));
        return mv;
    };*/

    @PostMapping("/addmovie")
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult result){
        if (result.hasErrors()){
            return "add-movie-form";
        }
        Movie movie = new Movie();
        movie.setTitle(movieForm.getTitle());
        movie.setGenre(movieForm.getGenre());
        movie.setDescription(movieForm.getDescription());
        movieService.registerMovie(movie);
        return "movie-added";
    }
}
