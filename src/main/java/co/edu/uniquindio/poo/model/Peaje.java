package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Peaje implements ICalculablePeaje, ICobradorPeaje {
    private String nombre;
    private String departamento;
    private double totalPeajeRecolectado;
    private List<RegistroPeaje> listaRegistroPeajes;
    private List<Recaudador> listaRecaudadores;

    public Peaje(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.totalPeajeRecolectado = 0;
        this.listaRegistroPeajes = new ArrayList<>();
        this.listaRecaudadores = new ArrayList<>();
    }

    @Override
    public double calcularPeaje(Vehiculo vehiculo) {
        return vehiculo.calcularPeaje();
    }

    @Override
    public RegistroPeaje cobrarPeaje(Vehiculo vehiculo) {
        double valor = calcularPeaje(vehiculo);
        vehiculo.incrementarPeajesPagados();
        totalPeajeRecolectado += valor;

        RegistroPeaje registro = new RegistroPeaje(
                vehiculo,
                this,
                valor,
                LocalDate.now(),
                LocalTime.now(),
                TipoEntidadCobro.ESTACION
        );

        registrarPago(registro);
        return registro;
    }

    public void registrarPago(RegistroPeaje registroPeaje) {
        listaRegistroPeajes.add(registroPeaje);
    }

    public void agregarRecaudador(Recaudador recaudador) {
        listaRecaudadores.add(recaudador);
    }

    public List<Camion> obtenerCamionesCargaMayor10YMasDe5Peajes() {
        List<Camion> camiones = new ArrayList<>();

        for (RegistroPeaje registro : listaRegistroPeajes) {
            Vehiculo vehiculo = registro.vehiculo();

            if (vehiculo instanceof Camion camion
                    && camion.getCapacidadCargaToneladas() > 10
                    && camion.getNumeroPeajesPagados() > 5
                    && !camiones.contains(camion)) {
                camiones.add(camion);
            }
        }

        return camiones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getTotalPeajeRecolectado() {
        return totalPeajeRecolectado;
    }

    public List<RegistroPeaje> getListaRegistroPeajes() {
        return listaRegistroPeajes;
    }
}