package org.ifa.fbansept.Alea.controller;

import com.fasterxml.jackson.annotation.JsonView;
import net.minidev.json.JSONObject;
import org.ifa.fbansept.Alea.DAO.DAOcard;
import org.ifa.fbansept.Alea.DAO.DAOturn;
import org.ifa.fbansept.Alea.jsonview.MyJsonView;
import org.ifa.fbansept.Alea.model.Card;
import org.ifa.fbansept.Alea.model.Turn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CardController {
    DAOcard cardDAO;
    DAOturn turnDAO;


    @Autowired
    public CardController(final DAOcard cardDAO) {
        this.cardDAO = cardDAO;
    }

    @GetMapping({"/listCard"})
    @JsonView(MyJsonView.Card.class)
    public List<Card> listCard(){
        List<Card> listCard = cardDAO.findAll();

        return listCard;
    }

    @GetMapping({"/cardView/{value}/{color}"})
    @JsonView(MyJsonView.Card.class)
    public Card getCardByValueAndColor(@PathVariable int value, @PathVariable String color, @RequestBody Turn turnToAdd){
        Card card = cardDAO.findByValueAndColor(value, color).orElse(null);

        if(card !=null){
            card.setSingleTurn(turnToAdd);
        } else {
            System.out.println("getCardByValueAndColor : " + "card null");
        }

        if(turnToAdd != null){
            turnToAdd.setSingleCard(card);
        } else{
            System.out.println("getCardByValueAndColor : " + "turn null");
        }


        return card;
    }

}
