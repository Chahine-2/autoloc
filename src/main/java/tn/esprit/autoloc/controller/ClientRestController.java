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
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/Client")
@AllArgsConstructor
public class ClientRestController {

    private final IClientService clientService;

    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.create(client);
    }

    @GetMapping("/afficherClient/{idClient}")
    public Client afficherClient(@PathVariable("idClient") Long id) {
        return clientService.findById(id);
    }

    @PutMapping("/modifierClient/{idClient}")
    public Client modifierClient(@PathVariable("idClient") Long id, @RequestBody Client client) {
        return clientService.update(id, client);
    }

    @GetMapping("/afficherListeClients")
    public List<Client> afficherListeClients() {
        return clientService.findAll();
    }

    @DeleteMapping("/supprimerClient/{idClient}")
    public void supprimerClient(@PathVariable("idClient") Long id) {
        clientService.deleteById(id);
    }
}
