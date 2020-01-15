package Views;

import Controllers.FavoritoController;
import Controllers.UtilizadorController;
import Models.Ativo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

public class FavoritosUI {

    private JTable table1;
    private JPanel panel1;

    private UtilizadorController uc;
    private FavoritoController fc;

    public FavoritosUI(UtilizadorController uc) {
        this.uc = uc;
        this.fc = new FavoritoController();
        popularTabela();
    }

    public void initComponents() {
        JFrame frame = new JFrame("Favoritos");
        frame.setContentPane(new FavoritosUI(uc).panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void popularTabela() {

        String[] columnNames = {"Ativo", "Valor de Venda", "Valor de Compra", "Eliminar"};
        DefaultTableModel dtModel = (DefaultTableModel) table1.getModel();
        dtModel.setColumnIdentifiers(columnNames);

        List<Ativo> favoritos = fc.getFavoritos(uc.getUtilizador()).getFavoritos();
        int favSize = favoritos.size();

        Object dados[] = new Object[4];
        for (int i = 0; i < favSize; i++) {
            dados[0] = favoritos.get(i).getNome();
            dados[1] = favoritos.get(i).getValorVenda();
            dados[2] = favoritos.get(i).getValorCompra();
            dados[3] = "Eliminar";
            dtModel.addRow(dados);
        }

        eliminarBtn();
    }

    private void eliminarBtn() {
        Action eliminarAtivo = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(table1, "Tem a certeza que pretende remover este Ativo da sua lista?");
                if (i == 0) {
                    Ativo a = fc.getFavoritos(uc.getUtilizador()).getAtivo((String) table1.getValueAt(Integer.parseInt(e.getActionCommand()), 0));
                    fc.apagarFavorito(uc.getUtilizador(), a);
                    ((DefaultTableModel) table1.getModel()).removeRow(Integer.parseInt(e.getActionCommand()));
                    JOptionPane.showMessageDialog(null, "Apagado!");
                }
            }
        };

        ButtonColumn bc = new ButtonColumn(table1, eliminarAtivo, 3);
    }
}
