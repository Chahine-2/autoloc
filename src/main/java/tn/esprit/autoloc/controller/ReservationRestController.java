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
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/Reservation")
@AllArgsConstructor
public class ReservationRestController {

    private final IReservationService reservationService;

    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }

    @GetMapping("/afficherReservation/{idReservation}")
    public Reservation afficherReservation(@PathVariable("idReservation") Long id) {
        return reservationService.findById(id);
    }

    @PutMapping("/modifierReservation/{idReservation}")
    public Reservation modifierReservation(@PathVariable("idReservation") Long id,
                                           @RequestBody Reservation reservation) {
        return reservationService.update(id, reservation);
    }

    @GetMapping("/afficherListeReservations")
    public List<Reservation> afficherListeReservations() {
        return reservationService.findAll();
    }

    @DeleteMapping("/supprimerReservation/{idReservation}")
    public void supprimerReservation(@PathVariable("idReservation") Long id) {
        reservationService.deleteById(id);
    }
}
