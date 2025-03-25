package com.example.restaurant.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String imageURL;
    private String mesure ;
    private boolean estDisponible;

    // Un menu dépend d'une seule catégorie
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // Constructeurs, getters et setters
    public Terrain() {

    }

  /*  public Terrain(String nom, Double prix, String description, String imageURL, Categorie categorie) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.imageURL = imageURL;
        this.categorie = categorie;
    }*/

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

    public String getMesure() {
        return mesure;
    }

    public void setMesure(String mesure) {
        this.mesure = mesure;
    }

    public boolean isEstDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}