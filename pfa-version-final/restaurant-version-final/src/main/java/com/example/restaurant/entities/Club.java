package com.example.restaurant.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nom est obligatoire")
    private String nom;
    private String Etablissement ;
    private String imageURL;


    public Club() {
    }

    public String getEtablissement() {
        return Etablissement;
    }

    public void setEtablissement(String etablissement) {
        Etablissement = etablissement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nom est obligatoire") String getNom() {
        return nom;
    }

    public void setNom(@NotBlank(message = "Nom est obligatoire") String nom) {
        this.nom = nom;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
