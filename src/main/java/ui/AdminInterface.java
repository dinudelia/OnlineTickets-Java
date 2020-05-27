package ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import managers.DBOperations;
import model.Event;
import service.IterateEventsService;
import service.RemoveEventService;

public class AdminInterface extends JFrame {


    private JButton addNewEventButton;
    private JButton deleteSelectedEventButton;
    private JButton refreshEventsButton;
    private JButton logout_btn = new JButton("LogOut");

    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    public DefaultTableModel tableModel = new DefaultTableModel();
    private JTable table = new JTable(tableModel);
    String selectedEventName="";
    Event selectedEvent=null;

    public void redrawTableModel(){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        for (Event e : IterateEventsService.getInstance().iterateEvents()) {
            tableModel.addRow( new Object[]{
                    e.getNameEvent(),
                    e.getLocation().getNameLocation(),
                    e.getLocation().getCity(),
                    e.getNrTickets(),
                    e.getPrice()});
        }
        table.setModel(tableModel);
        tableModel.fireTableDataChanged();
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                try{
                    selectEvent();
                } catch (Exception x) {
                    System.out.println("Error selecting index.");
                }
            }
        });

    }
    public AdminInterface() {

        setLayout(new GridLayout(2,1));
        setTitle("Admin Interface");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1 = new JPanel(new BorderLayout());
        String event = "";

        tableModel.addColumn("Name");
        tableModel.addColumn("Location");
        tableModel.addColumn("City");
        tableModel.addColumn("Nr.tickets");
        tableModel.addColumn("Price");

        redrawTableModel();
        add(p2);
        p1.add(table, BorderLayout.CENTER);
        p1.add(table.getTableHeader(),
                BorderLayout.NORTH);
        p2.add(addNewEventButton);
        p2.add(deleteSelectedEventButton);
        p2.add(logout_btn);
        p2.add(refreshEventsButton);
        logout_btn.addActionListener(ev -> logout());
        pack();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(p1);
        add(p2);
        setSize(400,400);
        repaint();
        addNewEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEventDialog addEventDialog = new AddEventDialog();
                addEventDialog.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent evt) {
                        redrawTableModel();
                    }
                });
            }
        });
        deleteSelectedEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedEvent = DBOperations.getEventByName(selectedEventName);
                System.out.println(selectedEvent);
                if (selectedEvent!=null) {
                    RemoveEventService.getInstance().removeEvent(selectedEvent);
                }
                redrawTableModel();
            }
        });
        refreshEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redrawTableModel();
            }
        });
    }

    public void selectEvent() {
        try {
            int selectedIndex = table.getSelectedRow();
            selectedEventName = tableModel.getValueAt(selectedIndex, 0).toString();
        } catch (Exception e) {
        }
    }

    public void logout() {
        new LoginFrame();
        dispose();
    }
}
