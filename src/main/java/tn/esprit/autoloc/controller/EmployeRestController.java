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
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/Employe")
@AllArgsConstructor
public class EmployeRestController {

    private final IEmployeService employeService;

    @PostMapping("/ajouterEmploye")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.create(employe);
    }

    @GetMapping("/afficherEmploye/{idEmploye}")
    public Employe afficherEmploye(@PathVariable("idEmploye") Long id) {
        return employeService.findById(id);
    }

    @PutMapping("/modifierEmploye/{idEmploye}")
    public Employe modifierEmploye(@PathVariable("idEmploye") Long id, @RequestBody Employe employe) {
        return employeService.update(id, employe);
    }

    @GetMapping("/afficherListeEmployes")
    public List<Employe> afficherListeEmployes() {
        return employeService.findAll();
    }

    @DeleteMapping("/supprimerEmploye/{idEmploye}")
    public void supprimerEmploye(@PathVariable("idEmploye") Long id) {
        employeService.deleteById(id);
    }
}
