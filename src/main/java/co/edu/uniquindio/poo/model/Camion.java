package co.edu.uniquindio.poo.model;

public class Camion extends Vehiculo {
    private int numeroEjes;
    private double capacidadCargaToneladas;

    public Camion(String placa, int numeroPeajesPagados, int numeroEjes, double capacidadCargaToneladas) {
        super(placa, numeroPeajesPagados);
        this.numeroEjes = numeroEjes;
        this.capacidadCargaToneladas = capacidadCargaToneladas;
    }

    @Override
    public double calcularPeaje() {
        double valor = numeroEjes * 7000;

        if (capacidadCargaToneladas > 10) {
            valor += valor * 0.10;
        }

        return valor;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public double getCapacidadCargaToneladas() {
        return capacidadCargaToneladas;
    }
}