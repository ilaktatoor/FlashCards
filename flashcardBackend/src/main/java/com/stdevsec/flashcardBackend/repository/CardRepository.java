package com.stdevsec.flashcardBackend.repository;

import com.stdevsec.flashcardBackend.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByLenguajeId(Long lenguajeId);
}
