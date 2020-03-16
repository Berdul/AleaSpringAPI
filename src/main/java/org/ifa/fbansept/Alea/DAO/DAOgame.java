package org.ifa.fbansept.Alea.DAO;

import org.ifa.fbansept.Alea.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DAOgame extends JpaRepository<Game, Integer> {
}
