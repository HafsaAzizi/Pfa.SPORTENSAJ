package com.example.restaurant.entities;
import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class ReservationTerrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec l'Equipe Etudiant
    @ManyToOne
    @JoinColumn(name = "etudiantequipe_id", nullable = false)
    private EtudiantEquipe etudiant_equipe;


    // Relation avec l'Equipe Professeur
    @ManyToOne
    @JoinColumn(name = "professeurequipe_id", nullable = false)
    private ProfesseurEquipe professeur_equipe;

    @NotNull
    private LocalDateTime dateReservation;

    @Enumerated(EnumType.STRING)
    private EtatReservationTerrain etatReservation = EtatReservationTerrain.EN_ATTENTE;



    @ManyToOne
    @JoinColumn(name = "terrain_id", nullable = false)
    private Terrain terrain;

    // Constructeur par défaut
    public ReservationTerrain() {
        this.dateReservation = LocalDateTime.now();
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EtudiantEquipe getEtudiant_equipe() {
        return etudiant_equipe;
    }

    public void setEtudiant_equipe(EtudiantEquipe etudiant_equipe) {
        this.etudiant_equipe = etudiant_equipe;
    }

    public ProfesseurEquipe getProfesseur_equipe() {
        return professeur_equipe;
    }

    public void setProfesseur_equipe(ProfesseurEquipe professeur_equipe) {
        this.professeur_equipe = professeur_equipe;
    }

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDateTime dateReservation) {
        this.dateReservation = dateReservation;
    }

    public EtatReservationTerrain getEtatReservation() {
        return etatReservation;
    }

    public void setEtatReservation(EtatReservationTerrain etatReservation) {
        this.etatReservation = etatReservation;
    }


}







// Liste des menus avec quantités
   /* @ElementCollection
    @CollectionTable(name = "commande_menus", joinColumns = @JoinColumn(name = "commande_id"))
    private List<ResultatMatchs> menus = new ArrayList<>();*/


// Méthode pour calculer le prix total
  /*  public void calculerPrixTotal() {
        this.prixTotal = menus.stream()
                .mapToDouble(menuQuantite -> menuQuantite.getMenu().getPrix() * menuQuantite.getQuantite())
                .sum();
    }*/

// Ajouter un terrain à la commande
   /* public void ajouterMenu(Terrain terrain, int quantite) {
        ResultatMatchs existingMenuQuantite = menus.stream()
                .filter(mq -> mq.getMenu().equals(terrain))
                .findFirst()
                .orElse(null);

        if (existingMenuQuantite != null) {
            existingMenuQuantite.setQuantite(existingMenuQuantite.getQuantite() + quantite);
        } else {
            menus.add(new ResultatMatchs(terrain, quantite));
        }
        calculerPrixTotal();
    }*/

// Supprimer un terrain de la commande
  /*  public void supprimerMenu(Terrain terrain) {
        menus.removeIf(menuQuantite -> menuQuantite.getMenu().equals(terrain));
        calculerPrixTotal();
    }*/