package Models;

public class Conta {

    private Utilizador u;

    /**
     * 0 - ADMIN
     * 1 - NORMAL
     */
    private int tipoUtilizador = 1;

    public Conta() {
    }

    public Conta(Utilizador u) {
        this.u = u;
    }

    public Utilizador getU() {
        return u;
    }

    public void setU(Utilizador u) {
        this.u = u;
    }

    public int getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(int tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }
}