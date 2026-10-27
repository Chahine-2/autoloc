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
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/Maintenance")
@AllArgsConstructor
public class MaintenanceRestController {

    private final IMaintenanceService maintenanceService;

    @PostMapping("/ajouterMaintenance")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.create(maintenance);
    }

    @GetMapping("/afficherMaintenance/{idMaintenance}")
    public Maintenance afficherMaintenance(@PathVariable("idMaintenance") Long id) {
        return maintenanceService.findById(id);
    }

    @PutMapping("/modifierMaintenance/{idMaintenance}")
    public Maintenance modifierMaintenance(@PathVariable("idMaintenance") Long id,
                                            @RequestBody Maintenance maintenance) {
        return maintenanceService.update(id, maintenance);
    }

    @GetMapping("/afficherListeMaintenances")
    public List<Maintenance> afficherListeMaintenances() {
        return maintenanceService.findAll();
    }

    @DeleteMapping("/supprimerMaintenance/{idMaintenance}")
    public void supprimerMaintenance(@PathVariable("idMaintenance") Long id) {
        maintenanceService.deleteById(id);
    }
}
