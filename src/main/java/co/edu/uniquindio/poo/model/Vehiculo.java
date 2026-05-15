package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    protected String placa;
    protected int numeroPeajesPagados;

    public Vehiculo(String placa, int numeroPeajesPagados) {
        this.placa = placa;
        this.numeroPeajesPagados = numeroPeajesPagados;
    }

    public abstract double calcularPeaje();

    public void incrementarPeajesPagados() {
        numeroPeajesPagados++;
    }

    public String getPlaca() {
        return placa;
    }

    public int getNumeroPeajesPagados() {
        return numeroPeajesPagados;
    }
}