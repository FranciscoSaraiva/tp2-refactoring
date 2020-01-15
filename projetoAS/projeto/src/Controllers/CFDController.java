package Controllers;

import Models.Ativo;
import Models.CFD;
import Models.Utilizador;

public class CFDController {

    public CFD getCFD(Utilizador utilizador, String nome){
        return utilizador.getPortfolio().getCFD(nome);
    }

    public CFD createCFD(Utilizador utilizador, Ativo ativo, double unidades, double stopLoss, double takeProfit, boolean isCompra) {

        double valorAbertura = ativo.getValorVenda();
        CFD cfd = new CFD(ativo, utilizador, unidades, stopLoss, takeProfit, isCompra, valorAbertura);
        utilizador.getPortfolio().getCfds().add(cfd);

        return cfd;
    }

    public void calcularSLTP(CFD cfd){
        throw new UnsupportedOperationException();
    }
}
