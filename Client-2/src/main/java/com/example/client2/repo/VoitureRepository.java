package com.example.client2.repo;

import com.example.client2.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long> {
}
