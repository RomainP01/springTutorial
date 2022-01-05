package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Data
public class FileMovieRepository implements MovieRepositoryInterface {
    FileWriter fileWriter;
    @Value("${movies.file.location}")
    File file;

    public void add(Movie movie) {
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(movie.getTitle() + ";" + movie.getGenre() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
