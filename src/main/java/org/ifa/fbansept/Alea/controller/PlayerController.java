package org.ifa.fbansept.Alea.controller;

import org.ifa.fbansept.Alea.DAO.DAOgame;
import org.ifa.fbansept.Alea.DAO.DAOplayer;
import org.ifa.fbansept.Alea.model.Game;
import org.ifa.fbansept.Alea.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin //(origins = "http://localhost:4200")
public class PlayerController {
    DAOplayer playerDAO;
    @Autowired
    public PlayerController(final DAOplayer playerDAO) {
        this.playerDAO = playerDAO;
    }

    @GetMapping("/")
    public String homepage(@PathVariable int id){
        return "Alea API. Ping success !";

    }

    @GetMapping("/listPlayer/{id}")
    public Player singlePlayer(@PathVariable int id){
        return playerDAO.findById(id).orElse(null);
    }

    @GetMapping({"/listPlayer"})
    public List<Player> listPlayer(){
        List<Player> listPlayer = playerDAO.findAll();

        return listPlayer;
    }


    @PostMapping({"/addPlayer"})
    Player addPlayer(@RequestBody Player player) {
        System.out.println(player.getBirthDate());
        return playerDAO.save(player);
    }
}
