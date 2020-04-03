package org.ifa.fbansept.Alea.controller;

import org.ifa.fbansept.Alea.DAO.DAOgame;
import org.ifa.fbansept.Alea.model.Game;
import org.ifa.fbansept.Alea.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin //(origins = "http://localhost:4200")

public class GameController {
    DAOgame gameDAO;
    @Autowired
    public GameController(final DAOgame gameDAO) {
        this.gameDAO = gameDAO;
    }

    @PostMapping({"/addGame"})
    Game addGame(@RequestBody Game game) {
        System.out.println("ECHO");
        return gameDAO.save(game);
    }

    @GetMapping("/listGame")
    List<Game> getGameList () {
        List<Game> listGame = gameDAO.findAll();

        return listGame;
    }

}
