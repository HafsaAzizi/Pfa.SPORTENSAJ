package com.example.restaurant.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
public class EtudiantEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nbr_joueurs ;
    private String nom_equipe;
    private String imageURL;

    // Une competition dépend d'une seule type de sport
  /*  @ManyToOne
    @JoinColumn(name = "typedesport_id")
    private TypeDeSport typedesport;*/

    public EtudiantEquipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbr_joueurs() {
        return nbr_joueurs;
    }

    public void setNbr_joueurs(int nbr_joueurs) {
        this.nbr_joueurs = nbr_joueurs;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
