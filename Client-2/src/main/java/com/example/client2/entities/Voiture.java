package com.example.client2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {

    @Id
    @GeneratedValue
    private Long id;
    private String marque;
    private String matricule;
    private String model;
    @JsonIgnore
    private Long id_client;
    @Transient
    private Client client;

    public Long getClientId() {
        return id_client;
    }
}
