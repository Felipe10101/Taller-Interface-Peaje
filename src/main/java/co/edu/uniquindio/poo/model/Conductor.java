package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.List;

public record Conductor(
        String nombre,
        String apellidos,
        String documentoIdentidad,
        LocalDate fechaNacimiento,
        List<Vehiculo> listaVehiculos
) {
}