package com.stdevsec.flashcardBackend.repository;

import com.stdevsec.flashcardBackend.entity.Lenguaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenguajeRepository extends JpaRepository<Lenguaje, Long> {
}
