package org.ifa.fbansept.Alea.DAO;

import org.ifa.fbansept.Alea.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DAOcard extends JpaRepository<Card, Integer> {
    Optional<Card> findByValueAndColor(int value, String color);
}
