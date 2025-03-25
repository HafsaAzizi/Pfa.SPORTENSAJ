package com.example.restaurant.entities;

import jakarta.persistence.*;

@Entity
public class CategorieCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom;

    // Constructeurs, getters et setters
    public CategorieCompetition() {
    }

    public CategorieCompetition(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
