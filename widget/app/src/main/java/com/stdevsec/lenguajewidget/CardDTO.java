package com.stdevsec.lenguajewidget;

public class CardDTO {
    private int id;
    private String palabra;
    private String pronunciacion;
    private String traduccion;
    private int lenguajeId;

    // Constructor
    public CardDTO(int id, String palabra, String pronunciacion, String traduccion, int lenguajeId) {
        this.id = id;
        this.palabra = palabra;
        this.pronunciacion = pronunciacion;
        this.traduccion = traduccion;
        this.lenguajeId = lenguajeId;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLenguajeId() {
        return lenguajeId;
    }

    public void setLenguajeId(int lenguajeId) {
        this.lenguajeId = lenguajeId;
    }
}
