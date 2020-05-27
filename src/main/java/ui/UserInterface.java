package ui;


import model.Client;
import service.IterateEventsService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {
    DefaultTableModel tableModel = new DefaultTableModel();
    private JTable eventsTable = new JTable(tableModel);
    private JButton buyTicketButton = new JButton("Buy Ticket");
    private JButton logout_btn = new JButton("LogOut");
    private JPanel p1 = new JPanel(new BorderLayout());
    private JPanel p2 = new JPanel(new FlowLayout());
    private JPanel p3 = new JPanel(new BorderLayout());

    JLabel avaibleEventsLabel = new JLabel("Avaible Events");
    JLabel basketContentLabel = new JLabel("Basket Content");
    JTextArea basketContent = new JTextArea();


    public UserInterface(Client client) {
        setLayout(new GridLayout(1, 2, 100, 100));
        setSize(800,300);
        setLocationRelativeTo(null);
        setTitle("List Of Events");

        tableModel.addColumn("Name");
        tableModel.addColumn("Location");
        tableModel.addColumn("City");
        tableModel.addColumn("Nr.tickets");
        tableModel.addColumn("Price");
        for (model.Event e : IterateEventsService.getInstance().iterateEvents()) {
            tableModel.insertRow(0, new Object[]{e.getNameEvent()
                    , e.getLocation().getNameLocation()
                    , e.getLocation().getCity()
                    , e.getNrTickets()
                    , e.getPrice()});
        }


        p1.add(eventsTable, BorderLayout.CENTER);
        p1.add(eventsTable.getTableHeader(), BorderLayout.NORTH);

        p2.add(buyTicketButton);
        p2.add(logout_btn);
        p3.add(p2, BorderLayout.NORTH);
        p3.add(basketContent,BorderLayout.CENTER);
        add(p1);
        add(p3);



        ListSelectionModel cellSelectionModel = eventsTable.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = eventsTable.getSelectedRow();
                String eventId = tableModel.getValueAt(selectedIndex, 0).toString();
            }
        });
        logout_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                dispose();
            }
        });

        new LoginFrame();
        dispose();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        buyTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
