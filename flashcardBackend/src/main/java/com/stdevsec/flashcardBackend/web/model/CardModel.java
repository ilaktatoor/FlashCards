package com.stdevsec.flashcardBackend.web.model;

import lombok.Data;

@Data
public class CardModel {

    private Long id;
    private String palabra;
    private String pronunciacion;
    private String traduccion;
    private Long lenguajeId;

    // Constructor with all fields set
    public CardModel(Long id, String palabra, String pronunciacion, String traduccion, Long lenguajeId) {
        this.id = id;
        this.palabra = palabra;
        this.pronunciacion = pronunciacion;
        this.traduccion = traduccion;
        this.lenguajeId = lenguajeId;
    }

    public Long getId() {
        return id;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPronunciacion() {
        return pronunciacion;
    }

    public void setPronunciacion(String pronunciacion) {
        this.pronunciacion = pronunciacion;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }

    public Long getLenguajeId() {
        return lenguajeId;
    }

    public void setLenguajeId(Long lenguajeId) {
        this.lenguajeId = lenguajeId;
    }
}
