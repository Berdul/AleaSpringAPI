package org.ifa.fbansept.Alea.DAO;

import org.ifa.fbansept.Alea.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DAOturn extends JpaRepository<Turn, Integer> {
}
