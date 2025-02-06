package com.stdevsec.flashcardBackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String palabra;

    private String pronunciacion;

    @Column(nullable = false)
    private String traduccion;

    @ManyToOne
    @JoinColumn(name = "lenguaje_id", nullable = false)
    private Lenguaje lenguaje;
}
