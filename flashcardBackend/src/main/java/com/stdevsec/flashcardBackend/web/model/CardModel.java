package com.stdevsec.flashcardBackend.web.model;

import lombok.Data;

@Data
public class CardModel {

    private Long id;
    private String palabra;
    private String pronunciacion;
    private String traduccion;
    private Long lenguajeId;

    public CardModel(Long id, String palabra, String pronunciacion, String traduccion, Long id1) {
    }
}
