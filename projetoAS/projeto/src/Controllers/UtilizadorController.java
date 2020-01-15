package Controllers;

import Models.*;

public class UtilizadorController {

    private Utilizador utilizador;

    public UtilizadorController(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void adicionarFundos(double quantia) {
        double novosFundos = calcularNovosFundos(quantia);
        utilizador.setFundos(novosFundos);
    }

    private double calcularNovosFundos(double quantia){
        return utilizador.getFundos() + quantia;
    }

    public void atualizarFundos() {
        throw new UnsupportedOperationException();
    }

    public double getFundos() {
        return utilizador.getFundos();
    }

}