package com.mycompany.dvdstore.core.repository.file;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Repository
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

    @Override
    public List<Movie> list() {
        List<Movie> movies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                final String[] titreEtGenre = line.split("\\;");
                final Movie movie = new Movie(Long.parseLong(titreEtGenre[0]), titreEtGenre[1], titreEtGenre[2], titreEtGenre[3]);
                movies.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Movie getById(long id) {
        final Movie movie = new Movie();
        movie.setId(id);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {

                final String[] allProperties = line.split("\\;");
                final long nextMovieId=Long.parseLong(allProperties[0]);
                if (nextMovieId==id) {
                    movie.setTitle(allProperties[1]);
                    movie.setGenre(allProperties[2]);
                    movie.setDescription(allProperties[3]);
                    return movie;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("A movie from the file does not have a proper id");
            e.printStackTrace();
        }
        movie.setTitle("UNKNOWN");
        movie.setGenre("UNKNOWN");
        movie.setDescription("UNKNOWN");
        return movie;
    }

}
