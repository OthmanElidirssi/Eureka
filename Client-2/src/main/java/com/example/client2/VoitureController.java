package com.example.client2;

import com.example.client2.entities.Voiture;
import com.example.client2.repo.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoitureController {

    private final VoitureRepository voitureRepository;
    private final ClientService clientService;

    @Autowired
    public VoitureController(VoitureRepository voitureRepository, ClientService clientService) {
        this.voitureRepository = voitureRepository;
        this.clientService = clientService;
    }

    @GetMapping(value = "/voitures", produces = {"application/json"})
    public ResponseEntity<Object> findAll() {
        try {
            List<Voiture> voitures = voitureRepository.findAll();
            return ResponseEntity.ok(voitures);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching voitures: " + e.getMessage());
        }
    }

    @GetMapping("/voitures/{Id}")
    public ResponseEntity<Object> findById(@PathVariable Long Id) {
        try {
            Voiture voiture = voitureRepository.findById(Id)
                    .orElseThrow(() -> new Exception("Voiture Introuvable"));

            // Fetch the client details using the clientService
            voiture.setClient(clientService.clientById(voiture.getClientId()));

            return ResponseEntity.ok(voiture);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Voiture not found with ID: " + Id);
        }
    }

}
