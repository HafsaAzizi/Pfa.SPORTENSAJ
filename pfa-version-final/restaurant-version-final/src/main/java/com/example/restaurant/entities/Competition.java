package com.example.restaurant.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String imageURL;

    @NotNull
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutCompetition etatCompetition = StatutCompetition.En_cours;

    // Un menu dépend d'une seule catégorie
    @ManyToOne
    @JoinColumn(name = "categoriecompetition_id")
    private CategorieCompetition CategorieCompetition;

    // Relation avec le club
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    // Une competition dépend d'une seule type de sport
    @ManyToOne
    @JoinColumn(name = "typedesport_id")
    private TypeDeSport typedesport;

    public Competition() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public @NotNull LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(@NotNull LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public StatutCompetition getEtatCompetition() {
        return etatCompetition;
    }

    public void setEtatCompetition(StatutCompetition etatCompetition) {
        this.etatCompetition = etatCompetition;
    }
}
