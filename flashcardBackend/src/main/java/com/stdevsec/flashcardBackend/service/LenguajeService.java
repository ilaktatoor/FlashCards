package com.stdevsec.flashcardBackend.service;

import com.stdevsec.flashcardBackend.entity.Lenguaje;
import com.stdevsec.flashcardBackend.repository.CardRepository;
import com.stdevsec.flashcardBackend.repository.LenguajeRepository;
import com.stdevsec.flashcardBackend.web.model.LenguajeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LenguajeService {

    @Autowired
    private LenguajeRepository repository;
    @Autowired
    private CardRepository cardRepository;

    public List<LenguajeModel>getAllLenguajes(){
        return repository.findAll()
                .stream()
                .map(lenguaje -> new LenguajeModel(lenguaje.getId(), lenguaje.getLanguajeName()))
                .collect(Collectors.toList());
    }

    public LenguajeModel createLenguaje(LenguajeModel model){
        Lenguaje lenguaje = new Lenguaje();
        lenguaje.setLanguajeName(model.getLenguajeName());
        Lenguaje savedLenguaje = repository.save(lenguaje);
        return new LenguajeModel(savedLenguaje.getId(),savedLenguaje.getLanguajeName());
    }

    public boolean deleteLenguaje(Long id){
        if(repository.existsById(id)){
            cardRepository.deleteAll(cardRepository.findByLenguajeId(id));
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
