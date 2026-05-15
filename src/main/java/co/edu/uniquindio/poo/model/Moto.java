package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(String placa, int numeroPeajesPagados, int cilindraje) {
        super(placa, numeroPeajesPagados);
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularPeaje() {
        double valor = 5000;

        if (cilindraje > 200) {
            valor += 2000;
        }

        return valor;
    }

    public int getCilindraje() {
        return cilindraje;
    }
}