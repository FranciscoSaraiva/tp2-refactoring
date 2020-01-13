package Controllers;

import Models.CFD;
import Models.Portfolio;
import Models.Utilizador;
import Persistance.CFDDAO;

public class PortfolioController {

    public Portfolio getPortfolio(Utilizador u){
        return u.getPortfolio();
    }

    public void encerrarCFD(Utilizador u, CFD cfd){
        u.getPortfolio().apagaCFD(cfd);
    }
}
