package com.mycompany.dvdstore.entitiy;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MovieForm {
    private Long id;
    @Size(max=20)
    private String title;
    private String genre;
    private String description;

    public MovieForm(Long id, String title, String genre, String description) {
        this.title = title;
        this.genre = genre;
        this.id = id;
        this.description = description;
    }

    public MovieForm() {
        this.title = null;
        this.genre = null;
        this.id = null;
        this.description = null;
    }


}
