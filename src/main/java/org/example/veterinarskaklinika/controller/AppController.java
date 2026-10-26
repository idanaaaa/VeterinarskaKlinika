
package org.example.veterinarskaklinika.controller;

import org.example.veterinarskaklinika.data.VetData;
import org.example.veterinarskaklinika.model.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    private final VetData data;

    public AppController(VetData data) {
        this.data = data;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/pets";
    }

    @GetMapping("/pets")
    public String pets(Model model) {
        model.addAttribute("pets", data.findAllPets());
        return "pets";
    }

    @GetMapping("/appointments")
    public String appointments(Model model) {
        model.addAttribute("appointments", data.findAllAppointments());
        model.addAttribute("pets", data.findAllPets());
        return "appointments";
    }

    @GetMapping("/pets/actions/{id}")
    public String petAction(@PathVariable Long id, Model model) {
        Pet pet = data.findPet(id);

        if (pet == null) {
            return "redirect:/pets";
        }

        model.addAttribute("pet", pet);
        model.addAttribute(
                "appointments",
                data.findAppointmentsByPetId(id)
        );

        return "appointments";
    }

    @PostMapping("/appointments/confirm/{id}")
    public String confirmAppointment(@PathVariable Long id) {
        data.confirmAppointment(id);
        return "redirect:/appointments";
    }
}
