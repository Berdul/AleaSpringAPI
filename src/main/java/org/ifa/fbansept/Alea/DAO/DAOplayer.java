package org.ifa.fbansept.Alea.DAO;

import org.ifa.fbansept.Alea.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DAOplayer extends JpaRepository<Player, Integer> {
}
