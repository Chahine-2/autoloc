package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/Paiement")
@AllArgsConstructor
public class PaiementRestController {

    private final IPaiementService paiementService;

    @GetMapping("/afficherPaiement/{idPaiement}")
    public Paiement afficherPaiement(@PathVariable("idPaiement") Long id) {
        return paiementService.findById(id);
    }

    @GetMapping("/afficherListePaiements")
    public List<Paiement> afficherListePaiements() {
        return paiementService.findAll();
    }
}
