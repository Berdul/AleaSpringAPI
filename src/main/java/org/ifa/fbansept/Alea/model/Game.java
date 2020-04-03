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
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private boolean isInGame;

    //All turns that have been played in that game
    @OneToMany (mappedBy = "game")
    private Set<Turn> turns;

    //List of players that participate to a game
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Game_Player",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> players;

    //Creator of the game (owner)
    @OneToOne(mappedBy = "gameOwned")
    private Player Player;

    //Player that won that game
    @ManyToOne
    @JoinColumn(name="winner_id")
    private Player winner;

    public Game() {
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
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
