package com.example.client;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private Float age;
}
