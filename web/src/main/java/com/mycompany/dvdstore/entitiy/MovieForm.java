package com.mycompany.dvdstore.entitiy;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class MovieForm {
    private Long id;
    @NotBlank(message="Veuillez entrer un titre")
    @Size(max = 20, message = "Entrez un titre de 20 caractères au plus")
    private String title;
    @NotBlank(message = "Veuillez entrer un genre")
    private String genre;
    @Size(max = 255,message = "Entrer une description de 255 caractères au plus")
    private String description;

}
