package org.ifa.fbansept.Alea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.ifa.fbansept.Alea.JsonView.MyJsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private Integer id;

    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private String firstname;

    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private String lastname;

    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private String email;
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private String password;

    @Temporal(TemporalType.DATE)
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private Date birthDate;

    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private int credit;

    //All turns that the player played

    @OneToMany(mappedBy = "player")
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private Set<Turn> turns;

    //List of game that the player participate in
    @ManyToMany(mappedBy = "players", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonView({MyJsonView.Player.class})
    private Set<Game> games;

    //Game that the player created
    @OneToOne
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    @JoinColumn(name = "gameOwned_id", referencedColumnName = "id")
    private Game gameOwned;

    //All games that the player won
    @OneToMany (mappedBy = "winner")
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private Set<Game> gamesWon;

    public Player() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Game getGameOwned() {
        return gameOwned;
    }

    public void setGameOwned(Game gameOwned) {
        this.gameOwned = gameOwned;
    }

    public Set<Game> getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(Set<Game> gamesWon) {
        this.gamesWon = gamesWon;
    }
}
