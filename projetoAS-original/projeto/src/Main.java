import Controllers.MercadoController;
import Controllers.UtilizadorController;
import Models.*;
import Views.*;
import Service.*;
import jdk.jshell.execution.Util;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        AtivoCreator creator = new AtivoCreator();
        Mercado m = creator.createAtivos();
        MercadoController mc = new MercadoController(m);

        Utilizador u1 = new Utilizador();
        UtilizadorController uc = new UtilizadorController(u1);

        new MainUI(uc, mc).initComponents();

    }


}
