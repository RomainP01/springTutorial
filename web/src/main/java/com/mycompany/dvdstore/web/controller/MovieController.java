package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.core.controller.MovieControllerInterface;
import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/movie")
@Controller
public class MovieController implements MovieControllerInterface {
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

    @RequestMapping("/{id}")
    public ModelAndView displayMovieCard(@PathVariable("id") Long id){
        System.out.println("movie details"+id);
        ModelAndView mv = new ModelAndView("movie-details");
        mv.addObject("movie",movieService.getMovieById(id));
        return mv;
    };
}
