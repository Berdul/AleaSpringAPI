package org.ifa.fbansept.Alea.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int nbPlayers;
    private String creationDate;
    private boolean isInGame;

    @OneToMany (mappedBy = "game")
    private Set<Turn> turns;

    @ManyToMany
    @JoinTable(
            name = "Game_Player",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> players;

    @OneToOne(mappedBy = "game")
    private Player Player;

    @ManyToOne
    @JoinColumn(name="winner_id")
    private Player winner;

    public Game() {
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getNbPlayers() {
        return nbPlayers;
    }

    public void setNbPlayers(int nbPlayers) {
        this.nbPlayers = nbPlayers;
    }

    public boolean isInGame() {
        return isInGame;
    }

    public void setInGame(boolean inGame) {
        isInGame = inGame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }

    public Set<org.ifa.fbansept.Alea.model.Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<org.ifa.fbansept.Alea.model.Player> players) {
        this.players = players;
    }

    public org.ifa.fbansept.Alea.model.Player getPlayer() {
        return Player;
    }

    public void setPlayer(org.ifa.fbansept.Alea.model.Player player) {
        Player = player;
    }

    public org.ifa.fbansept.Alea.model.Player getWinner() {
        return winner;
    }

    public void setWinner(org.ifa.fbansept.Alea.model.Player winner) {
        this.winner = winner;
    }
}
