package Views;

import Controllers.AuthController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUII {

    private JButton LoginButton;
    private JPanel panel1;
    private JTextField Username;
    private JLabel JLabelPass;
    private JLabel JLabelUsername;
    private JPasswordField passwordField1;

    private JFrame j;

    private AuthController ac;

    public LoginUII() {
        ac = new AuthController();
        actions();
    }

    public void initComponents() {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new LoginUII().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void actions() {
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = Username.getText();
                String pass = new String(passwordField1.getPassword());
                if (ac.logIn(user, pass)) {
                    JOptionPane.showMessageDialog(null, "Sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Combinação incorreta");
                }
            }
        });
    }

}
