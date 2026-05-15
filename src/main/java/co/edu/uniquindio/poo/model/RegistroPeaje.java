package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public record RegistroPeaje(
        Vehiculo vehiculo,
        ICobradorPeaje entidadCobro,
        double valorCobrado,
        LocalDate fechaCobro,
        LocalTime horaCobro,
        TipoEntidadCobro tipoEntidadCobro
) {
}