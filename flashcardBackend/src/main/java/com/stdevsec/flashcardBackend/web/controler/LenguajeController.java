package com.stdevsec.flashcardBackend.web.controler;

import com.stdevsec.flashcardBackend.service.LenguajeService;
import com.stdevsec.flashcardBackend.web.model.LenguajeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lenguajes")
public class LenguajeController {

    @Autowired
    private LenguajeService service;

    @GetMapping
    public List<LenguajeModel> getAllLenguajes(){
        return service.getAllLenguajes();
    }

    @PostMapping
    public LenguajeModel createLenguaje(@RequestBody LenguajeModel model){
        return service.createLenguaje(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLenguaje(@PathVariable Long id){
        if (service.deleteLenguaje(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
