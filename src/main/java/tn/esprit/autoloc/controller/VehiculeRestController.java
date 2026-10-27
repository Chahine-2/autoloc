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
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/Vehicule")
@AllArgsConstructor
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.create(vehicule);
    }

    @GetMapping("/afficherVehicule/{idVehicule}")
    public Vehicule afficherVehicule(@PathVariable("idVehicule") Long id) {
        return vehiculeService.findById(id);
    }

    @PutMapping("/modifierVehicule/{idVehicule}")
    public Vehicule modifierVehicule(@PathVariable("idVehicule") Long id, @RequestBody Vehicule vehicule) {
        return vehiculeService.update(id, vehicule);
    }

    @GetMapping("/afficherListeVehicules")
    public List<Vehicule> afficherListeVehicules() {
        return vehiculeService.findAll();
    }

    @DeleteMapping("/supprimerVehicule/{idVehicule}")
    public void supprimerVehicule(@PathVariable("idVehicule") Long id) {
        vehiculeService.deleteById(id);
    }
}
