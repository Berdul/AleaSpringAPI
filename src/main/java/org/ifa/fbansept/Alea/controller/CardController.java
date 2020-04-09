package org.ifa.fbansept.Alea.controller;

import org.ifa.fbansept.Alea.DAO.DAOcard;
import org.ifa.fbansept.Alea.model.Card;
import org.ifa.fbansept.Alea.model.Turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
public class CardController {
    DAOcard cardDAO;
    @Autowired
    public CardController(final DAOcard cardDAO) {
        this.cardDAO = cardDAO;
    }

    @GetMapping({"/listCard"})
    public List<Card> listTurn(){
        List<Card> listCard = cardDAO.findAll();

        for(Card card : listCard){
            for(Turn turn: card.getTurns()){
                turn.setCards(new HashSet<>());
            }
        }


        return listCard;
    }

}
