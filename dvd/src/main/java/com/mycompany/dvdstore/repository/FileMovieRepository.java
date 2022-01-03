package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;

import java.io.FileWriter;
import java.io.IOException;

public class FileMovieRepository implements MovieRepositoryInterface {
    FileWriter fileWriter;
    public void add(Movie movie){
        try{
            fileWriter=new FileWriter("C:\\temp\\movies.txt",true);
            fileWriter.write(movie.getTitle()+";"+movie.getGenre()+"\n");
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
