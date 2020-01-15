package Views;

import Controllers.CFDController;
import Controllers.MercadoController;
import Controllers.UtilizadorController;
import Models.Ativo;
import Models.CFD;
import Models.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CfdUI {

    private JRadioButton compraRadioButton;
    private JRadioButton vendaRadioButton;
    private JTextField txtUnidades;
    private JTextField txtSL;
    private JTextField txtTP;
    private JPanel panel1;
    private JButton cfdBtn;

    private UtilizadorController uc;
    private CFDController cc;
    private Ativo a;


    public CfdUI(Ativo a, UtilizadorController uc) {
        this.a = a;
        this.uc = uc;
        this.cc = new CFDController();
        cfdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novoCFD();
            }
        });
    }

    public void initComponents() {
        JFrame frame = new JFrame("CFD");
        frame.setContentPane(new CfdUI(a, uc).panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void novoCFD() {

        boolean isCompra;
        double sl = Double.parseDouble(txtSL.getText());
        double tp = Double.parseDouble(txtTP.getText());
        double unidades = Double.parseDouble(txtUnidades.getText());

        if (compraRadioButton.isSelected()) {
            isCompra = true;
        } else {
            isCompra = false;
        }

        CFD c = cc.createCFD(uc.getU(), a, unidades, sl, tp, isCompra);

        if(c != null) {
            JOptionPane.showMessageDialog(null, "CFD criado com sucesso! \nConsultar Portfolio para mais informação.", null, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Inválido! Tente novamente.", null, JOptionPane.ERROR_MESSAGE);
        }

        System.out.println(c.toString());

    }
}
