package com.stdevsec.flashcardBackend.service;

import com.stdevsec.flashcardBackend.entity.Card;
import com.stdevsec.flashcardBackend.repository.CardRepository;
import com.stdevsec.flashcardBackend.repository.LenguajeRepository;
import com.stdevsec.flashcardBackend.web.model.CardModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    @Autowired
    private LenguajeRepository lenguajeRepository;

    public List<CardModel>getAllCards(){
        return repository.findAll().stream()
                .map(card -> new CardModel(
                        card.getId(),
                        card.getPalabra(),
                        card.getPronunciacion(),
                        card.getTraduccion(),
                        card.getLenguaje().getId()
                )).collect(Collectors.toList());
    }

    public List<CardModel> getCardsByLenguaje(Long lenguajeId){
        return repository.findByLenguajeId(lenguajeId).stream()
                .map(card -> new CardModel(
                        card.getId(),
                        card.getPalabra(),
                        card.getPronunciacion(),
                        card.getTraduccion(),
                        card.getLenguaje().getId()
                )).collect(Collectors.toList());
    }

    public CardModel createCard(CardModel model){
        return lenguajeRepository.findById(model.getLenguajeId()).map(lenguaje -> {
            Card card = new Card();
            card.setPalabra(model.getPalabra());
            card.setPronunciacion(model.getPronunciacion());
            card.setTraduccion(model.getTraduccion());
            card.setLenguaje(lenguaje);

            Card savedCard = repository.save(card);

            return new CardModel(
                    savedCard.getId(),
                    savedCard.getPalabra(),
                    savedCard.getPronunciacion(),
                    savedCard.getTraduccion(),
                    savedCard.getLenguaje().getId()
            );
        }).orElse(null);
    }

    public CardModel editCard(Long id, CardModel model){
       return repository.findById(id).map(card ->{
           card.setPalabra(model.getPalabra());
           card.setPronunciacion(model.getPronunciacion());
           card.setTraduccion(model.getTraduccion());
           return lenguajeRepository.findById(model.getLenguajeId()).map(lenguaje -> {
               card.setLenguaje(lenguaje);
               Card editedCard = repository.save(card);
               return new CardModel(
                       editedCard.getId(),
                       editedCard.getPalabra(),
                       editedCard.getPronunciacion(),
                       editedCard.getTraduccion(),
                       editedCard.getLenguaje().getId()
               );
           }).orElse(null);
       }).orElse(null);
    }

    public boolean deleteCard(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }


}
