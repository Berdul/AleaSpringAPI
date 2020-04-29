package org.ifa.fbansept.Alea.controller;


import org.ifa.fbansept.Alea.model.Player;
import org.ifa.fbansept.Alea.security.JwtUtil;
import org.ifa.fbansept.Alea.security.MyPlayerDetails;
import org.ifa.fbansept.Alea.security.MyPlayerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthPlayerController {

    private AuthenticationManager authenticationManager;
    private MyPlayerDetailsService myPlayerDetailsService;
    private JwtUtil jwtUtil;

    @Autowired
    public AuthPlayerController(
            AuthenticationManager authenticationManager,
            MyPlayerDetailsService myPlayerDetailsService,
            JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.myPlayerDetailsService = myPlayerDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authentification")
    public ResponseEntity<String> authentification(@RequestBody Player player) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            player.getEmail(), player.getPassword()));
        }
        catch (BadCredentialsException e) {
            throw new Exception("Pseudo ou mot de passe incorrect", e);
        }

        final UserDetails PlayerDetails = myPlayerDetailsService
                .loadUserByUsername(player.getEmail());

        return ResponseEntity.ok(jwtUtil.generateToken(PlayerDetails));
    }
}