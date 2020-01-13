package Controllers;

import Models.Ativo;
import Models.CFD;
import Models.Utilizador;

public class CFDController {

    public CFD getCFD(Utilizador u, String nome){
        return u.getPortfolio().getCFD(nome);
    }

    public CFD createCFD(Utilizador u, Ativo a, double unidades, double sl, double tp, boolean isCompra) {

        CFD cfd = new CFD();

        cfd.setUtilizador(u);
        cfd.setAtivo(a);
        cfd.setStopLoss(sl);
        cfd.setTakeProfit(tp);
        cfd.setCompra(isCompra);
        cfd.setValorAbertura(a.getValorVenda());
        cfd.setQuantidade(unidades);

        u.getPortfolio().getCfds().add(cfd);

        //cfdDAO.save(cfd)

        return cfd;
    }

    public void calcularSLTP(CFD cfd){
        //TODO - FAZER ISTO
        throw new UnsupportedOperationException();
    }
}
