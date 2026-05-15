package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Recaudador implements ICobradorPeaje {
    private String nombre;
    private String apellidos;
    private String documentoIdentidad;
    private LocalDate fechaNacimiento;
    private double sueldoMensual;
    private Peaje peaje;

    public Recaudador(String nombre, String apellidos, String documentoIdentidad,
                      LocalDate fechaNacimiento, double sueldoMensual, Peaje peaje) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documentoIdentidad = documentoIdentidad;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoMensual = sueldoMensual;
        this.peaje = peaje;
    }

    @Override
    public RegistroPeaje cobrarPeaje(Vehiculo vehiculo) {
        double valor = peaje.calcularPeaje(vehiculo);
        vehiculo.incrementarPeajesPagados();

        RegistroPeaje registro = new RegistroPeaje(
                vehiculo,
                this,
                valor,
                LocalDate.now(),
                LocalTime.now(),
                TipoEntidadCobro.RECAUDADOR
        );

        peaje.registrarPago(registro);
        return registro;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }
}