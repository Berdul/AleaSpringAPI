package org.ifa.fbansept.Alea.DAO;

import org.ifa.fbansept.Alea.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DAOutilisateur extends JpaRepository<Utilisateur, Integer> {
}
