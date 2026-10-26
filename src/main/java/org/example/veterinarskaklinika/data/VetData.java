
package org.example.veterinarskaklinika.data;

import org.example.veterinarskaklinika.model.Appointment;
import org.example.veterinarskaklinika.model.Pet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VetData {

    private final List<Pet> pets = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();

    public VetData() {
        pets.add(new Pet(1L, "Luna", "Buldog", "Pas"));
        pets.add(new Pet(2L, "Tigrica", "Sibirska", "Mačka"));
        pets.add(new Pet(3L, "Max", "Chivava", "Pas"));

        appointments.add(new Appointment(
                1L, "2026-03-11", "20:35", "Zakazano", 1L));
        appointments.add(new Appointment(
                2L, "2026-04-01", "15:35", "Zakazano", 2L));
        appointments.add(new Appointment(
                3L, "2026-07-12", "16:02", "Zakazano", 3L));
    }

    public List<Pet> findAllPets() {
        return pets;
    }

    public List<Appointment> findAllAppointments() {
        return appointments;
    }

    public Pet findPet(Long id) {
        return pets.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Pronalazi termine određenog ljubimca
    public List<Appointment> findAppointmentsByPetId(Long petId) {
        return appointments.stream()
                .filter(a -> a.getPetId().equals(petId))
                .toList();
    }

    // Pronalazi jedan termin prema njegovom ID-u
    public Appointment findAppointment(Long id) {
        return appointments.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Potvrđuje termin
    public boolean confirmAppointment(Long id) {
        Appointment appointment = findAppointment(id);

        if (appointment == null) {
            return false;
        }

        appointment.setStatus("Prihvaceno");
        return true;
    }
}
