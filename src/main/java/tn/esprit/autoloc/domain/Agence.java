package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;

import java.util.List;


@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder @EqualsAndHashCode
@Table(name = "agence")
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 50)
    private String ville;

    @Column(nullable = false, length = 150)
    private String adresse;

    @Column(length = 20)
    private String telephone;

    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<Employe> employes = new ArrayList<>();

    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<Vehicule> vehicules = new ArrayList<>();
}
