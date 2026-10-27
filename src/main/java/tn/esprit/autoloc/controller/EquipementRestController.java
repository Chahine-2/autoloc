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
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/Equipement")
@AllArgsConstructor
public class EquipementRestController {

    private final IEquipementService equipementService;

    @PostMapping("/ajouterEquipement")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.create(equipement);
    }

    @GetMapping("/afficherEquipement/{idEquipement}")
    public Equipement afficherEquipement(@PathVariable("idEquipement") Long id) {
        return equipementService.findById(id);
    }

    @PutMapping("/modifierEquipement/{idEquipement}")
    public Equipement modifierEquipement(@PathVariable("idEquipement") Long id, @RequestBody Equipement equipement) {
        return equipementService.update(id, equipement);
    }

    @GetMapping("/afficherListeEquipements")
    public List<Equipement> afficherListeEquipements() {
        return equipementService.findAll();
    }

    @DeleteMapping("/supprimerEquipement/{idEquipement}")
    public void supprimerEquipement(@PathVariable("idEquipement") Long id) {
        equipementService.deleteById(id);
    }
}
