package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder @EqualsAndHashCode
@Table(name = "employe")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RoleEmploye role;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agence agence;
}
