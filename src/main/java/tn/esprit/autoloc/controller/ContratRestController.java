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
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/Contrat")
@AllArgsConstructor
public class ContratRestController {

    private final IContratService contratService;

    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.create(contrat);
    }

    @GetMapping("/afficherContrat/{idContrat}")
    public Contrat afficherContrat(@PathVariable("idContrat") Long id) {
        return contratService.findById(id);
    }

    @PutMapping("/modifierContrat/{idContrat}")
    public Contrat modifierContrat(@PathVariable("idContrat") Long id, @RequestBody Contrat contrat) {
        return contratService.update(id, contrat);
    }

    @GetMapping("/afficherListeContrats")
    public List<Contrat> afficherListeContrats() {
        return contratService.findAll();
    }

    @DeleteMapping("/supprimerContrat/{idContrat}")
    public void supprimerContrat(@PathVariable("idContrat") Long id) {
        contratService.deleteById(id);
    }
}
