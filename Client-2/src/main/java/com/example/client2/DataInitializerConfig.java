package com.example.client2;

import com.example.client2.entities.Client;
import com.example.client2.entities.Voiture;
import com.example.client2.repo.VoitureRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

@Configuration
public class DataInitializerConfig {

    @Bean
    public CommandLineRunner initializeData(VoitureRepository voitureRepository, ClientService clientService) {
        return args -> {
            Client c1 = clientService.clientById(2L);
            Client c2 = clientService.clientById(1L);

            System.out.println("**************************");
            System.out.println("Id est :" + c2.getId());
            System.out.println("Nom est :" + c2.getNom());
            System.out.println("**************************");

            System.out.println("**************************");
            System.out.println("Id est :" + c1.getId());
            System.out.println("Nom est :" + c1.getNom());
            System.out.println("Nom est :" + c1.getAge());
            System.out.println("**************************");

            voitureRepository.save(new Voiture(Long.parseLong("1"), "Toyota", "A 25 333", "Corolla", 1L, c2));
            voitureRepository.save(new Voiture(Long.parseLong("2"), "Renault", "B 6 3456", "Megane", 1L, c2));
            voitureRepository.save(new Voiture(Long.parseLong("3"), "Peugeot", "A 55 4444", "301", 2L, c1));
        };
    }
}
