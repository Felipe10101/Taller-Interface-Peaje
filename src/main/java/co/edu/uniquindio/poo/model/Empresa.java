package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<Peaje> listaPeajes;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaPeajes = new ArrayList<>();
    }

    public void agregarEstacion(Peaje estacionPeaje) {
        listaPeajes.add(estacionPeaje);
    }

    public List<Camion> obtenerCamionesCargaMayor10YMasDe5Peajes() {
        List<Camion> camiones = new ArrayList<>();

        for (Peaje peaje : listaPeajes) {
            camiones.addAll(peaje.obtenerCamionesCargaMayor10YMasDe5Peajes());
        }

        return camiones;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Peaje> getListaPeajes() {
        return listaPeajes;
    }
}