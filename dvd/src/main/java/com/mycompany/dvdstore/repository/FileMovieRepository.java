package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Data
public class FileMovieRepository implements MovieRepositoryInterface {
    FileWriter fileWriter;
    File file;
    public void add(Movie movie){
        try{
            fileWriter=new FileWriter(file,true);
            fileWriter.write(movie.getTitle()+";"+movie.getGenre()+"\n");
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
