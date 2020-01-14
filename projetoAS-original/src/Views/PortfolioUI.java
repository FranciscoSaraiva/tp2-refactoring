package Views;

import Controllers.PortfolioController;
import Controllers.UtilizadorController;
import Models.CFD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

public class PortfolioUI {

    private JTable portfolioTBL;
    private JPanel panel1;

    private PortfolioController pc;
    private UtilizadorController uc;

    public PortfolioUI(UtilizadorController uc) {
        this.pc = new PortfolioController();
        this.uc = uc;
        popularTabela();
    }

    public void initComponents() {
        JFrame frame = new JFrame("Portfólio");
        frame.setContentPane(new PortfolioUI(uc).panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void popularTabela() {

        String[] columnNames = {"Ativo", "Quantidade", "Valor de Abertura", "Stop Loss", "Take Profit", "CFD de Compra", " "};
        DefaultTableModel dtModel = (DefaultTableModel) portfolioTBL.getModel();
        dtModel.setColumnIdentifiers(columnNames);

        List<CFD> portfolio = pc.getPortfolio(uc.getU()).getCfds();
        int portSize = portfolio.size();


        Object dados[] = new Object[7];
        for (int i = 0; i < portSize; i++) {
            dados[0] = portfolio.get(i).getAtivo().getNome();
            dados[1] = portfolio.get(i).getQuantidade();
            dados[2] = portfolio.get(i).getValorAbertura();
            dados[3] = portfolio.get(i).getStopLoss();
            dados[4] = portfolio.get(i).getTakeProfit();
            dados[5] = portfolio.get(i).isCompra();
            dados[6] = "Encerrar";
            dtModel.addRow(dados);
        }

        encerrarBtn();
    }

    private void encerrarBtn() {
        Action encerrarCFD = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(portfolioTBL, "Tem a certeza que pretende encerrar este CFD?");
                if (i == 0) {
                    CFD c = pc.getPortfolio(uc.getU()).getCFD((String) portfolioTBL.getValueAt(Integer.parseInt(e.getActionCommand()), 0));
                    pc.encerrarCFD(uc.getU(), c);
                    ((DefaultTableModel) portfolioTBL.getModel()).removeRow(Integer.parseInt(e.getActionCommand()));
                    JOptionPane.showMessageDialog(null, "Encerrado!");
                }
            }
        };

        ButtonColumn bc = new ButtonColumn(portfolioTBL, encerrarCFD, 6);
    }
}
