package com.example.restaurant.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class CreationCompteEtudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nom est obligatoire")
    private String nom_responsable;
    @NotBlank(message = "Prenom Du Responsable est obligatoire")
    private String prenom_responsable;
    @NotBlank(message = "Email est obligatoire")
    private String email;
    @NotBlank(message = "Password est obligatoire")
    private String password;
    @NotBlank(message = "Filière est obligatoire")
    private String Filière ;


    public CreationCompteEtudiant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nom est obligatoire") String getNom_responsable() {
        return nom_responsable;
    }

    public void setNom_responsable( String nom_responsable) {
        this.nom_responsable = nom_responsable;
    }

    public  String getPrenom_responsable() {
        return prenom_responsable;
    }

    public void setPrenom_responsable( String prenom_responsable) {
        this.prenom_responsable = prenom_responsable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFilière() {
        return Filière;
    }

    public void setFilière(String filière) {
        Filière = filière;
    }
}
