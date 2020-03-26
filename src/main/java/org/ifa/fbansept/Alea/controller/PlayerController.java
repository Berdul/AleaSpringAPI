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

    @GetMapping("/")
    public String homepage(@PathVariable int id){
        return "Alea API. Ping success !";

    }

    @GetMapping("/listPlayer/{id}")
    public Player singlePlayer(@PathVariable int id){
        return playerDAO.findById(id).orElse(null);
    }

    @PutMapping("/updatePlayer")
    public Player updateSinglePlayer(@RequestBody Player playerToUpdate){
        Player playerInDB = playerDAO.findById( playerToUpdate.getId() ).orElse(null);
        if ( playerInDB != null){
            playerInDB.setAge( playerToUpdate.getAge() );
            playerInDB.setLastname( playerToUpdate.getLastname() );
            playerInDB.setFirstname( playerToUpdate.getFirstname() );

            return playerDAO.save(playerInDB);
        } else {
            return null;
        }
    }


    @GetMapping({"/listPlayer"})
    public List<Player> listPlayer(){
        return playerDAO.findAll();
    }


    @PostMapping({"/addPlayer"})
    Player addPlayer(@RequestBody Player player) {
        return playerDAO.save(player);
    }
}
