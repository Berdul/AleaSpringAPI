package org.ifa.fbansept.Alea.controller;


import org.ifa.fbansept.Alea.model.Player;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Index {
    @GetMapping("/listPlayer/{id}")
    public String singleUtilisateur(@PathVariable int id){
        return "HOMEPAGE : Welcome to Alea API !";

    }
}
