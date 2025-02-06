package com.stdevsec.flashcardBackend.web.controler;

import com.stdevsec.flashcardBackend.entity.Card;
import com.stdevsec.flashcardBackend.service.CardService;
import com.stdevsec.flashcardBackend.web.model.CardModel;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService service;

    @GetMapping
    public List<CardModel> getAllCards(){
        return service.getAllCards();
    }

    @GetMapping("/lenguaje/{lenguajeId}")
    public List<CardModel> getCardsByLenguaje(@PathVariable Long lenguajeId){
        return service.getCardsByLenguaje(lenguajeId);
    }

    @GetMapping("/random")
    public CardModel getRandomCard() {
        return service.getRandomCard();
    }

    @PostMapping
    public ResponseEntity<CardModel> createCard(@RequestBody CardModel model){
        CardModel createdCard = service.createCard(model);
        if(createdCard != null){
            return ResponseEntity.ok(createdCard);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<CardModel> editCard(@PathVariable Long id, @RequestBody CardModel model){
        CardModel editedCard = service.createCard(model);
        if(editedCard != null){
            return ResponseEntity.ok(editedCard);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id){
        if(service.deleteCard(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
