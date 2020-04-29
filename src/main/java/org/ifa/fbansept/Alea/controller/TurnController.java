package org.ifa.fbansept.Alea.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.dialect.MySQL5Dialect;
import org.ifa.fbansept.Alea.DAO.DAOcard;
import org.ifa.fbansept.Alea.DAO.DAOturn;
import org.ifa.fbansept.Alea.jsonview.MyJsonView;
import org.ifa.fbansept.Alea.model.Card;
import org.ifa.fbansept.Alea.model.Game;
import org.ifa.fbansept.Alea.model.Player;
import org.ifa.fbansept.Alea.model.Turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/turn")
public class TurnController {
    DAOturn turnDAO;
    @Autowired
    public TurnController(DAOturn turnDAO) {
        this.turnDAO = turnDAO;
    }

    @GetMapping("/listTurn")
    @JsonView(MyJsonView.Turn.class)
    public List<Turn> listTurn(){
        return turnDAO.findAll();
    }

    @GetMapping("/listTurn/{id}")
    @JsonView(MyJsonView.Turn.class)
    public Turn turnById (@PathVariable int id){
        return turnDAO.findById(id).orElse(null);
    }


    @GetMapping("/addTurn")
    @JsonView(MyJsonView.Turn.class)
    public Turn addCardToTurn(Turn turn){

        return turnDAO.save(turn);
    }

    @PostMapping("/save")
    public boolean saveCard(@RequestBody Turn turn) throws Exception {
        turnDAO.save(turn);
        return true;
    }

    @PostMapping("/addGameToTurn/{turnId}")
    @JsonView(MyJsonView.Game.class)
    boolean addTurnToGame(@RequestBody Game game, @PathVariable int turnId){
        Turn turn = turnDAO.findById(turnId).orElse(null);
        turn.setGame(game);
        turnDAO.save(turn);

        return true;
    }
}
