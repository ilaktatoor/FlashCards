package com.stdevsec.flashcardBackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Lenguaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String languajeName;

    @OneToMany(mappedBy = "lenguaje", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards = new ArrayList<>();

    public Lenguaje( ) {}

    public Lenguaje(Long id, String languajeName, List<Card> cards) {
        this.id = id;
        this.languajeName = languajeName;
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguajeName() {
        return languajeName;
    }

    public void setLanguajeName(String languajeName) {
        this.languajeName = languajeName;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
