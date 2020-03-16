package org.ifa.fbansept.Alea.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int countPlayer;

    public Game() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCountPlayer() {
        return countPlayer;
    }

    public void setCountPlayer(int countPlayer) {
        this.countPlayer = countPlayer;
    }
}
