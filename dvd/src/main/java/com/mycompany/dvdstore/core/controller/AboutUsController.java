package com.mycompany.dvdstore.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;


public class AboutUsController {

    @RequestMapping("/about-us")
    public String displayFullDetails(){
        System.out.println("Tentative d'affichage de l'a-propos");
        return "about-us";
    }
}