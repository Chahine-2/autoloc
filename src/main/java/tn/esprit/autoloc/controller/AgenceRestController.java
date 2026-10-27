package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/Agence")
@AllArgsConstructor
public class AgenceRestController {

    private final IAgenceService agenceService;

    @PostMapping("/ajouterAgence")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.create(agence);
    }

    @GetMapping("/afficherAgence/{idAgence}")
    public Agence afficherAgence(@PathVariable("idAgence") Long id) {
        return agenceService.findById(id);
    }

    @PutMapping("/modifierAgence/{idAgence}")
    public Agence modifierAgence(@PathVariable("idAgence") Long id, @RequestBody Agence agence) {
        return agenceService.update(id, agence);
    }

    @GetMapping("/afficherListeAgences")
    public List<Agence> afficherListeAgences() {
        return agenceService.findAll();
    }

    @DeleteMapping("/supprimerAgence/{idAgence}")
    public void supprimerAgence(@PathVariable("idAgence") Long id) {
        agenceService.deleteById(id);
    }
}
