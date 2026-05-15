package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeajeTest {

    @Test
    public void calcularPeajeSegunTipoVehiculo() {
        Carro carroElectricoPublico = new Carro(
                "KJM343",
                0,
                true,
                TipoServicio.PUBLICO
        );
        Moto motoAltoCilindraje = new Moto(
                "MOT123",
                0,
                250
        );
        Camion camionCargaMayor10 = new Camion(
                "GHM167",
                0,
                3,
                12
        );

        assertEquals(9200, carroElectricoPublico.calcularPeaje());
        assertEquals(7000, motoAltoCilindraje.calcularPeaje());
        assertEquals(23100, camionCargaMayor10.calcularPeaje());
    }

    @Test
    public void obtenerCamionesCargaMayor10YMasDe5Peajes() {
        Empresa empresa = new Empresa("Peajes del Quindio");
        Peaje peaje = new Peaje("Peaje Armenia", "Quindio");
        empresa.agregarEstacion(peaje);

        Camion camionValido = new Camion(
                "CAM123",
                6,
                3,
                12
        );
        Camion camionCargaMenor = new Camion(
                "CAM456",
                8,
                3,
                8
        );
        Camion camionPocosPeajes = new Camion(
                "CAM789",
                4,
                3,
                15
        );
        Carro carro = new Carro(
                "ABC123",
                10,
                false,
                TipoServicio.PARTICULAR
        );

        peaje.cobrarPeaje(camionValido);
        peaje.cobrarPeaje(camionCargaMenor);
        peaje.cobrarPeaje(camionPocosPeajes);
        peaje.cobrarPeaje(carro);

        List<Camion> resultado = empresa.obtenerCamionesCargaMayor10YMasDe5Peajes();

        assertTrue(resultado.contains(camionValido));
    }
}
