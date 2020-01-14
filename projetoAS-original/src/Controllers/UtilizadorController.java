package Controllers;

import Models.*;

public class UtilizadorController {

    private Utilizador u;

    public UtilizadorController(Utilizador u) {
        this.u = u;
    }

    public Utilizador getU() {
        return u;
    }

    public void adicionarFundos(double quantia) {
        u.setFundos(u.getFundos() + quantia);
    }

    public void atualizarFundos() {
        // TODO - implement UtilizadorController.atualizarFundos //@SMELL dispensable
        throw new UnsupportedOperationException();
    }

    public double getFundos() {
        return u.getFundos();
    }

}