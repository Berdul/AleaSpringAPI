package org.ifa.fbansept.Alea.controller;

import org.ifa.fbansept.Alea.DAO.DAOcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CardController {
    DAOcard cardDAO;
    @Autowired
    public CardController(final DAOcard cardDAO) {
        this.cardDAO = cardDAO;
    }
}
