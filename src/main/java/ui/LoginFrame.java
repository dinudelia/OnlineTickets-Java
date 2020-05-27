package ui;

import model.Client;
import service.LoginService;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JLabel e1 = new JLabel("Username:");
    private JTextField user_name = new JTextField(10);
    private JLabel e2 = new JLabel("Password:");
    private JTextField password = new JPasswordField(10);
    private JButton log_in = new JButton("Log In");
    private JLabel label2;
    private JButton create_account;
    private JLabel label1;
    private JLabel label0;
    private LoginService loginService;

    public LoginFrame() {
        setLayout(new GridLayout(4, 1));
        loginService = LoginService.getInstance();
        add(p1);
        add(p2);
        add(p3);
        add(p4);

        p1.add(e1);
        p1.add(user_name);

        p2.add(e2);
        p2.add(password);

        p3.add(log_in);
        p4.add(label2);
        p4.add(create_account);

        create_account.addActionListener(ev -> create());
        log_in.addActionListener(ev -> login());

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void create() {
        new CreateAccount();
    }

    public void login() {
        String username = user_name.getText();
        String password = this.password.getText();

        LoginService loginService = LoginService.getInstance();
        Client client = loginService.login(username,password);


        if (client!=null){
            UserInterface userInterface = new UserInterface(client);
        }
        else

            if (username.equals("admin") && password.equals("admin")){
                AdminInterface userInterface = new AdminInterface();
        }

            else JOptionPane.showMessageDialog(null,
                    "User or password incorrect. Please try again!");

    }
}


