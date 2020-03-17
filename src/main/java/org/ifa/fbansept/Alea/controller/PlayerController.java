package org.ifa.fbansept.Alea.controller;

import org.ifa.fbansept.Alea.DAO.DAOplayer;
import org.ifa.fbansept.Alea.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //(origins = "http://localhost:4200")

public class PlayerController {
    DAOplayer playerDAO;
    @Autowired
    public PlayerController(final DAOplayer playerDAO) {
        this.playerDAO = playerDAO;
    }

    @GetMapping("/listPlayer/{id}")
    public Player singleUtilisateur(@PathVariable int id){
        System.out.println("Single utilisateur");
        return playerDAO.findById(id).orElse(null);

    }

    @GetMapping({"/listPlayer"})
    public List<Player> listUtilisateur(){
        System.out.println("Liste des utilisateurs");
        return playerDAO.findAll();
    }


    @PostMapping({"/listPlayer"})
    Player addUser(@RequestBody Player player) {
        System.out.println("ECHO");
        return playerDAO.save(player);
    }
}
