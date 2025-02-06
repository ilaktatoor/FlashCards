package com.stdevsec.flashcardBackend.web.model;

import lombok.Data;

@Data
public class LenguajeModel {
    private Long id;
    private String lenguajeName;

    public LenguajeModel() { }

    public LenguajeModel(Long id, String lenguajeName) {
        this.id = id;
        this.lenguajeName = lenguajeName;
    }
}
