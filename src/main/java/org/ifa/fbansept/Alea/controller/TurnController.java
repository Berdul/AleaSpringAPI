package org.ifa.fbansept.Alea.controller;

import org.ifa.fbansept.Alea.DAO.DAOturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TurnController {
    DAOturn turnDAO;
    @Autowired
    public TurnController(DAOturn turnDAO) {
        this.turnDAO = turnDAO;
    }
}
