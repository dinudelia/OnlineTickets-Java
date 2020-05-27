package managers;


import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {


    public static void addEvent(Event event) {
        String sql1 = "INSERT INTO location(nameLocation,city) VALUES (?,?)";
        int insertedId=0;
        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement1 = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement1.setString(1, event.getLocation().getNameLocation());
            statement1.setString(2, event.getLocation().getCity());
            statement1.executeUpdate();
            ResultSet rs = statement1.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
                System.out.println(insertedId);
            }
        } catch (SQLException e) {
        }

        String sql2 = "INSERT INTO event(nameEvent,nrTickets,price,idLocation ) VALUES(?,?,?,?)";
        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement2 = con.prepareStatement(sql2);
        ) {
            statement2.setString(1, event.getNameEvent());
            statement2.setInt(2, event.getNrTickets());
            statement2.setInt(3, event.getPrice());
            statement2.setInt(4, insertedId);
            statement2.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eroare la adaugare eveniment");
        }
    }


    public static void deleteEvent(Event event) {
        String sql = "DELETE FROM event WHERE nameEvent=?";
        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setString(1, event.getNameEvent());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }


    public static List<Event> allEvents() {
        String sql = "SELECT * FROM event A " +
                "INNER JOIN location B " +
                "ON A.idLocation=B.idLocation";
        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {

            ResultSet set = statement.executeQuery();
            List<Event> eventsList = new ArrayList<>();
            while (set.next()) {
                int idLocation = set.getInt("idLocation");
                String city = set.getString("city");
                String nameLocation = set.getString("nameLocation");
                Location location = new Location(idLocation,city,nameLocation);
                int idEvent = set.getInt("idEvent");
                String nameEvent = set.getString("nameEvent");
                int nrTickets = set.getInt("nrTickets");
                int price = set.getInt("price");
                Event event = new Event(idEvent,nameEvent,nrTickets,price,location);
                eventsList.add(event);
            }
            return eventsList;
        } catch (SQLException e) {
            return null;
        }
    }


    public static void addLocation(Location location) {
        String sql1 = "INSERT INTO location(nameLocation,city) VALUES (?,?)";
        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement1 = con.prepareStatement(sql1);
        ) {
            statement1.setString(1, location.getNameLocation());
            statement1.setString(2, location.getCity());
            statement1.executeUpdate();
        } catch (SQLException e) {
        }
    }


    public static void deleteLocation(Location location) {
        String sql = "DELETE FROM location WHERE idLocation=?";
        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setInt(1, location.getIdLocation());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }


    public static List<Location> allLocations() {
        String sql = "SELECT * FROM location";
        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {

            ResultSet set = statement.executeQuery();
            List<Location> locationsList = new ArrayList<>();
            while (set.next()) {
                int idLocation = set.getInt("idLocation");
                String city = set.getString("city");
                String nameLocation = set.getString("nameLocation");
                Location location = new Location(idLocation,city,nameLocation);
                locationsList.add(location);
            }
            return locationsList;
        } catch (SQLException e) {
            return null;
        }
    }


    public static void addTicketToBasket(Event event,Client client,int nrTickets){
        String sql="INSERT INTO basket(idClient,idEvent,nrTickets) VALUES ( ?,?,?)";

        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setInt(1, client.getIdUser());
            statement.setInt(2, event.getIdEvent());
            statement.setInt(3,1);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Event getEventByName(String nameEvent) {
        String sql = "SELECT * from event WHERE nameEvent=?";
        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setString(1, nameEvent);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                return new Event(
                        set.getInt("idEvent"),
                        set.getString("nameEvent"),
                        set.getInt("nrTickets"),
                        set.getInt("price"),
                        getLocationById(set.getInt("idLocation")));
            }
        } catch (SQLException e) {
            System.out.println("erorr  retrieving event");
        }
        return null;
    }


    public static void addClient(Client client) {
        String sql1 = "INSERT INTO user(username,password) VALUES (?, ?)";
        String sql2 = "INSERT INTO client(firstname,lastName,idUser,seniority) VALUES (?, ?, ?, ?)";

        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement1 = con.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
                PreparedStatement statement2 = con.prepareStatement(sql2);

        ) {
            statement1.setString(1, client.getUsername());
            statement1.setString(2, client.getPassword());
            statement1.executeUpdate();

            ResultSet rs = statement1.getGeneratedKeys();
            int insertedId=0;
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
            if (insertedId!=0) {
                statement2.setString(1, client.getFirstName());
                statement2.setString(2, client.getLastName());
                statement2.setInt(3, insertedId);
                statement2.setInt(4, 1);

                statement2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static List<Client> allClients() {
        String sql = "SELECT * FROM client A " +
                "INNER JOIN user B " +
                "ON A.idUser=B.idUser";
        List<Client> clients = new ArrayList<>();
        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                int clientId = set.getInt("idClient");
                String userName = set.getString("userName");
                String password = set.getString("password");
                String firstName = set.getString("firstName");
                String lastName = set.getString("lastName");
                int seniority = set.getInt("seniority");
                Client client = new Client(clientId, userName, password, firstName, lastName, seniority);
                clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println("exceptie");
        }
        return clients;
    }


    public static Location getLocationById(int idLocation){
        String sql = "SELECT * FROM location WHERE idLocation = ?";

        try (
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setInt(1, idLocation);

            ResultSet set = statement.executeQuery(); // in RS avem randurile din tabela
            if (set.next()) {
                int id = set.getInt("idLocation");
                String u = set.getString("nameLocation");
                String p = set.getString("city");
                return new Location(id,p,u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
