package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("ABC123", 0, true, TipoServicio.PUBLICO);
        Moto moto = new Moto("MOT123", 0, 250);
        Camion camion = new Camion("CAM123", 6, 3, 12);

        System.out.println("Peaje carro: " + carro.calcularPeaje());
        System.out.println("Peaje moto: " + moto.calcularPeaje());
        System.out.println("Peaje camion: " + camion.calcularPeaje());

        Empresa empresa = new Empresa("Peajes del Quindio");
        Peaje peaje = new Peaje("Peaje Armenia", "Quindio");

        empresa.agregarEstacion(peaje);
        peaje.cobrarPeaje(camion);

        System.out.println("Camiones carga > 10 y peajes > 5:");
        for (Camion c : empresa.obtenerCamionesCargaMayor10YMasDe5Peajes()) {
            System.out.println(c.getPlaca());
        }
    }
}