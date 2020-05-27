package ui;

import model.Client;
import model.User;
import repositories.IClientRepository;

import javax.swing.*;
import java.awt.*;

public class CreateAccount extends JFrame {
    private JTextField txt_username = new JTextField(10);
    private JTextField txt_FirstName = new JTextField(10);
    private JPasswordField txt_password2 = new JPasswordField(10);
    private JPasswordField txt_password = new JPasswordField(10);
    private JTextField txt_LastName = new JTextField(10);
    private JButton btn_submit;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JLabel lbl_password2;
    private JLabel lbl_FirstName;
    private JLabel lbl_LastName;

    public CreateAccount() {

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        setSize(400,200);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lbl_username, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txt_username, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lbl_username, gbc);



        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lbl_password, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txt_password, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lbl_password2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txt_password2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lbl_FirstName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(txt_FirstName, gbc);


        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lbl_LastName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(txt_LastName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        gbc.gridheight=100;
        add(btn_submit, gbc);


        btn_submit.addActionListener(actionEvent -> submit());

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void submit() {
            String username = txt_username.getText();
            String password = txt_password.getText();
            String lastname = txt_LastName.getText();
            String firstname = txt_FirstName.getText();
            Client client = new Client(0,
                                username,
                                password,
                                lastname,
                                firstname,
                                1);
        IClientRepository.build(IClientRepository.Type.DB).addClient(client);
        IClientRepository.build(IClientRepository.Type.ARRAY).addClient(client);
        IClientRepository.build(IClientRepository.Type.FILE).addClient(client);

        JOptionPane.showMessageDialog(null, "Account created succesfully");
            setVisible(false);
            dispose();
    }
}
