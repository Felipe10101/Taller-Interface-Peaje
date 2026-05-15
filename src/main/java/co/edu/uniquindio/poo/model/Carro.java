package co.edu.uniquindio.poo.model;

public class Carro extends Vehiculo {
    private boolean electrico;
    private TipoServicio tipoServicio;

    public Carro(String placa, int numeroPeajesPagados, boolean electrico, TipoServicio tipoServicio) {
        super(placa, numeroPeajesPagados);
        this.electrico = electrico;
        this.tipoServicio = tipoServicio;
    }

    @Override
    public double calcularPeaje() {
        double valor = 10000;

        if (electrico) {
            valor -= valor * 0.20;
        }

        if (tipoServicio == TipoServicio.PUBLICO) {
            valor += valor * 0.15;
        }

        return valor;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }
}
