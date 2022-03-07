package com.mycompany.dvdstore.core.repository.mysql;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class MovieRepository implements MovieRepositoryInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Movie add(Movie movie) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO MOVIE (TITLE,GENRE,DESCRIPTION) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,movie.getTitle());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setString(3, movie.getDescription());
            return preparedStatement;
        },keyHolder);
        movie.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return movie;

    }

    @Override
    public List<Movie> list() {
        return jdbcTemplate.query("SELECT ID, TITLE, GENRE FROM movie",
                (rs,rowNum) -> new Movie(rs.getLong("ID"),rs.getString("TITLE"), rs.getString("GENRE"))
        );
    }

    @Override
    public Movie getById(long id) {
        return jdbcTemplate.queryForObject("SELECT ID, TITLE, GENRE, DESCRIPTION FROM movie WHERE ID =?",
                new Object[]{id},
                (rs,rowNum)-> new Movie(rs.getLong("ID"),rs.getString("TITLE"), rs.getString("GENRE"), rs.getString("DESCRIPTION")));
    }
}
