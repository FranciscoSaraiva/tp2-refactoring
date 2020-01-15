import Controllers.MercadoController;
import Controllers.UtilizadorController;
import Models.*;
import Views.*;
import Service.*;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<Moeda> moedas;
        List<Indice> indices;
        List<Acao> acoes;

        AtivoCreatorMoeda creatorMoeda = new AtivoCreatorMoeda();
        moedas = creatorMoeda.createAtivos();

        AtivoCreatorIndice creatorIndice = new AtivoCreatorIndice();
        indices = creatorIndice.createAtivos();

        AtivoCreatorAcao creatorAcao = new AtivoCreatorAcao();
        acoes = creatorAcao.createAtivos();

        Mercado mercado = new Mercado(indices, acoes, moedas);
        MercadoController mc = new MercadoController(mercado);

        Utilizador utilizador = new Utilizador();
        UtilizadorController uc = new UtilizadorController(utilizador);

        new MainUI(uc, mc).initComponents();
    }


}
