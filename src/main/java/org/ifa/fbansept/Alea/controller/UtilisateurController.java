package org.ifa.fbansept.Alea.controller;

import org.ifa.fbansept.Alea.DAO.DAOutilisateur;
import org.ifa.fbansept.Alea.DAO.DAOutilisateur;
import org.ifa.fbansept.Alea.model.Utilisateur;
import org.ifa.fbansept.Alea.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //(origins = "http://localhost:4200")

public class UtilisateurController {
    DAOutilisateur utilisateurDAO;
    @Autowired
    public UtilisateurController(final DAOutilisateur utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }

    @GetMapping("/listUtilisateur/{id}")
    public Utilisateur singleUtilisateur(@PathVariable int id){
        System.out.println("Single utilisateur");
        return utilisateurDAO.findById(id).orElse(null);

    }

    @GetMapping({"/listUtilisateur"})
    public List<Utilisateur> listUtilisateur(){
        System.out.println("Liste des utilisateurs");
        return utilisateurDAO.findAll();
    }

}
