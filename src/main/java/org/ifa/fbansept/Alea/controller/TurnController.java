package org.ifa.fbansept.Alea.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.ifa.fbansept.Alea.DAO.DAOturn;
import org.ifa.fbansept.Alea.jsonview.MyJsonView;
import org.ifa.fbansept.Alea.model.Card;
import org.ifa.fbansept.Alea.model.Game;
import org.ifa.fbansept.Alea.model.Player;
import org.ifa.fbansept.Alea.model.Turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
public class TurnController {
    DAOturn turnDAO;
    @Autowired
    public TurnController(DAOturn turnDAO) {
        this.turnDAO = turnDAO;
    }

    @GetMapping({"/listTurn"})
    @JsonView(MyJsonView.Turn.class)
    public List<Turn> listTurn(){
        List<Turn> listTurn = turnDAO.findAll();

        /*
        for(Turn turn : listTurn){
            for(Card card : turn.getCards()){
                card.setTurns(new HashSet<>());
            }
        }
         */

        return listTurn;
    }

}
