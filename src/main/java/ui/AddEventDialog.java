package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Event;
import model.Location;
import service.AddEventService;

public class AddEventDialog extends JFrame {
    private JLabel nameOfEventLabel;
    private JLabel numberOfTicketsLabel;
    private JLabel priceLabel;
    private JLabel locationLabel;
    private JLabel cityLabel;
    private JTextField txt_name_event;
    private JTextField txt_number_tickets;
    private JTextField txt_price;
    private JTextField txt_location;
    private JTextField txt_city;
    private JButton btn_save;


public AddEventDialog(){

    GridBagLayout layout = new GridBagLayout();
    setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    setSize(300,200);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    add(nameOfEventLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    add(txt_name_event, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    add(numberOfTicketsLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    add(txt_number_tickets, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    add(priceLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    add(txt_price, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    add(priceLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 3;
    add(txt_price, gbc);


    gbc.gridx = 0;
    gbc.gridy = 4;
    add(locationLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 4;
    add(txt_location, gbc);

    gbc.gridx = 0;
    gbc.gridy = 5;
    add(cityLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 5;
    add(txt_city, gbc);


    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 2;
    add(btn_save, gbc);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    btn_save.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            add_event();
        }

    });
}

public void add_event(){
        {
            Location location=new Location(0,txt_location.getText(),txt_city.getText());
            Event event=new Event(0,
                    txt_name_event.getText(),
                    Integer.parseInt(txt_number_tickets.getText()),
                    Integer.parseInt(txt_price.getText()),
                    location);
            event.setLocation(location);
            AddEventService.getInstance().addEvent(event);
            JOptionPane.showMessageDialog(null, "Event added");
            dispose();
        }
}
}

