package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder @EqualsAndHashCode
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    @Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Column(length = 500)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicule vehicule;

}
