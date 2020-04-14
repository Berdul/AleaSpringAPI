package org.ifa.fbansept.Alea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.ifa.fbansept.Alea.jsonview.MyJsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({MyJsonView.Card.class, MyJsonView.Turn.class})
    private Integer id;

    @JsonView({MyJsonView.Card.class, MyJsonView.Turn.class})
    private int value;

    @JsonView({MyJsonView.Card.class, MyJsonView.Turn.class})
    private String color;

    //All turns that are linked to that card
    @ManyToMany(mappedBy = "cards")
    @JsonView({MyJsonView.Card.class})
    Set<Turn> turns;

    public Card() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }
}
