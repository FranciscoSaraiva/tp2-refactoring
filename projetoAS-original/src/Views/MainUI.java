package Views;

import Controllers.MercadoController;
import Controllers.UtilizadorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI {
    private JButton mercadoButton;
    private JPanel panel1;
    private JButton portfolioButton;
    private JButton definiçõesButton;
    private JButton loginButton;
    private JButton registarButton;
    private JButton favoritosButton;

    private MercadoController mc;
    private UtilizadorController uc;

    public MainUI(UtilizadorController uc, MercadoController mc) {
        this.mc = mc;
        this.uc = uc;
        actions();
    }

    public void initComponents() {
        JFrame frame = new JFrame("Olá");
        frame.setContentPane(new MainUI(uc, mc).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void actions() {

        mercadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MercadoUI(uc, mc).initComponents();
            }
        });

        portfolioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PortfolioUI(uc).initComponents();
            }
        });

        favoritosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FavoritosUI(uc).initComponents();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginUII().initComponents();
            }
        });

        registarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterUI().initComponents();
            }
        });
    }
}
