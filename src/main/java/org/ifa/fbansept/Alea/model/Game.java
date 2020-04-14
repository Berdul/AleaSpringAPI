package org.ifa.fbansept.Alea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.ifa.fbansept.Alea.jsonview.MyJsonView;
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
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private Integer id;

    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private int nbPlayers;

    @Temporal(TemporalType.DATE)
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private Date creationDate;

    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private boolean isInGame;

    //All turns that have been played in that game
    @OneToMany (mappedBy = "game")
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private Set<Turn> turns;

    //List of players that participate to a game
    @ManyToMany//(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Game_Player",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    @JsonView({MyJsonView.Game.class})
    private Set<Player> players;

    //Creator of the game (owner)
    @JsonIgnore
    @OneToOne(mappedBy = "gameOwned")
    private Player owner;

    //Player that won that game
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="winner_id")
    @JsonView({MyJsonView.Game.class})
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

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
