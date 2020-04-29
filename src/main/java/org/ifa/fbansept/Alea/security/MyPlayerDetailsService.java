package org.ifa.fbansept.Alea.security;

import org.ifa.fbansept.Alea.DAO.DAOplayer;
import org.ifa.fbansept.Alea.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyPlayerDetailsService implements UserDetailsService {
    @Autowired
    DAOplayer playerDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Player player = playerDao.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Inconnu : " + email));
        return new MyPlayerDetails(player);
    }
}
