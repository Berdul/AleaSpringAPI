package org.ifa.fbansept.Alea.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.ifa.fbansept.Alea.DAO.DAOgame;
import org.ifa.fbansept.Alea.jsonview.MyJsonView;
import org.ifa.fbansept.Alea.model.Game;
import org.ifa.fbansept.Alea.model.Player;
import org.ifa.fbansept.Alea.model.Turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin //(origins = "http://localhost:4200")
@RequestMapping("/game")
public class GameController {
    DAOgame gameDAO;
    @Autowired
    public GameController(final DAOgame gameDAO) {
        this.gameDAO = gameDAO;
    }

    @PostMapping("/addGameToPlayer")
    Player addPlayerToGame(Player player){
        player.addGame(gameDAO.findById(1).orElse(null));
        return player;
    }

    @PostMapping({"/addGame"})
    Game addGame(@RequestBody Game game) {
        System.out.println("ECHO");
        return gameDAO.save(game);
    }

    @GetMapping("/listGame")
    @JsonView(MyJsonView.Game.class)
    List<Game> getGameList () {
        List<Game> listGame = gameDAO.findAll();

        return listGame;
    }

    @GetMapping("/listGame/{id}")
    @JsonView(MyJsonView.Game.class)
    Game getGameById(@PathVariable int id){
        return gameDAO.findById(id).orElse(null);
    }

    @PostMapping("/addTurnToGame/{gameId}")
    @JsonView(MyJsonView.Game.class)
    boolean addTurnToGame(@RequestBody Turn turn, @PathVariable int gameId){
        Game game = gameDAO.findById(gameId).orElse(null);
        game.getTurns().add(turn);
        gameDAO.save(game);

        return true;
    }


}
