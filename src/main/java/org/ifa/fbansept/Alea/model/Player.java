package org.ifa.fbansept.Alea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.ifa.fbansept.Alea.jsonview.MyJsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "player")
public class Player{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class, MyJsonView.Turn.class})
    private Integer id;

    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class, MyJsonView.Turn.class})
    private String firstname;

    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class, MyJsonView.Turn.class})
    private String lastname;

    @Column(unique = true)
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class, MyJsonView.Turn.class})
    private String email;

    private String password;

    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class, MyJsonView.Turn.class})
    private boolean active;

    @ManyToMany(mappedBy = "players", fetch = FetchType.EAGER)
    @JsonView({MyJsonView.Turn.class})
    private List<Role> roles;

    @Temporal(TemporalType.DATE)
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class, MyJsonView.Turn.class})
    private Date birthDate;

    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class, MyJsonView.Turn.class})
    private int credit;

    //All turns that the player player
    @OneToMany(mappedBy = "player")
    @JsonView({MyJsonView.Player.class, MyJsonView.Game.class})
    private Set<Turn> turns;

    //List of game that the player participate in
    @ManyToMany(mappedBy = "players")//, cascade = CascadeType.ALL)
    @JsonView({MyJsonView.Player.class})
    private Set<Game> games;

    //Game that the player created
    @OneToOne
    @JoinColumn(name = "gameOwned_id", referencedColumnName = "id")
    @JsonView({MyJsonView.Player.class, MyJsonView.Turn.class})
    private Game gameOwned;

    //All games that the player won
    @OneToMany (mappedBy = "winner")
    @JsonView({MyJsonView.Player.class, MyJsonView.Turn.class})
    private Set<Game> gamesWon;

    public Player() {
    }

    public void addGame(Game game){
        this.games.add(game);
        game.getPlayers().add(this);
    }

    //region --Getters and Setters

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    //endregion
}
