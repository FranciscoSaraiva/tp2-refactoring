package Views;

import javax.swing.*;

public class RegisterUI {

    private JButton registarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JTextField textField3;
    private JPanel jpanel;

    public void initComponents() {
        JFrame frame = new JFrame("Registo");
        frame.setContentPane(new RegisterUI().jpanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
