package Views;

import Controllers.MercadoController;
import Controllers.UtilizadorController;
import Models.Ativo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

public class MercadoUI {

    private JPanel panel1;
    private JLabel mercadoLabel;
    private JTable ativosTbl;

    private MercadoController mc;
    private UtilizadorController uc;

    public MercadoUI(UtilizadorController uc, MercadoController mc) {
        this.uc = uc;
        this.mc = mc;
        popularTabela();
    }

    public void initComponents() {
        JFrame frame = new JFrame("Mercado");
        frame.setContentPane(new MercadoUI(uc, mc).panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void popularTabela() {
        String[] columnNames = {"Ativo", "Valor de Compra", "Valor de Venda", "Negociar", "Favorito"};
        DefaultTableModel dtModel = (DefaultTableModel) ativosTbl.getModel();
        dtModel.setColumnIdentifiers(columnNames);

        List<Ativo> mercado = mc.getMercadoCompleto();
        int mercadoSize = mercado.size();

        Object dados[] = new Object[5];
        for (int i = 0; i < mercadoSize; i++) {
            dados[0] = mercado.get(i).getNome();
            dados[1] = mercado.get(i).getValorCompra();
            dados[2] = mercado.get(i).getValorVenda();
            dados[3] = "Criar CFD";
            dados[4] = "Adicionar";
            dtModel.addRow(dados);
        }

        criarBtnCFD();
        criarBtnFavorito();
    }

    private void criarBtnCFD() {
        Action novoCFD = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ativo a = mc.getAtivo((String) ativosTbl.getValueAt(Integer.parseInt(e.getActionCommand()), 0));
                new CfdUI(a, uc).initComponents();
            }
        };

        ButtonColumn bc = new ButtonColumn(ativosTbl, novoCFD, 3);
    }

    private void criarBtnFavorito() {
        Action favorito = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ativo a = mc.getAtivo((String) ativosTbl.getValueAt(Integer.parseInt(e.getActionCommand()), 0));
                if(uc.getU().getFavorito().getFavoritos().add(a)) {
                    JOptionPane.showMessageDialog(null, "Adicionado! \nConsultar lista de Favoritos.");
                }
            }
        };

        ButtonColumn bc = new ButtonColumn(ativosTbl, favorito, 4);
    }

}