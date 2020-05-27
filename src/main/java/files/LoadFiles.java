package files;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class LoadFiles {
    File usersFile = new File("USERS");
    File clientsFile = new File("CLIENTS");
    File eventsFile = new File("EVENTS");
    File locationsFile = new File("LOCATIONS");

    Scanner usersInput;
    Scanner clientsInput;
    Scanner eventsInput;
    Scanner locationsInput;

    public LoadFiles() {
        try {
            usersInput = new Scanner(usersFile);
            clientsInput = new Scanner(clientsFile);
            eventsInput = new Scanner(eventsFile);
            locationsInput = new Scanner(locationsFile);
        } catch (FileNotFoundException e) {
        }
    }

    public List<Client> loadClients() {
        List<Client> clients = new ArrayList<Client>();

        try {
            clientsInput.nextLine();
            while (clientsInput.hasNext()) {
                String line = clientsInput.nextLine();
                String elements[] = line.split(",");
                Client c = new Client(
                        0,
                        elements[0],
                        elements[1],
                        elements[2],
                        elements[3],
                        Integer.parseInt(elements[4])
                );
                clients.add(c);
            }
        } catch (Exception e) {
        }
        return clients;
    }

    public List<Event> loadEvents() {
        List<Event> events = new ArrayList<Event>();

        try {
            eventsInput.nextLine();
            while (eventsInput.hasNext()) {
                String line = eventsInput.nextLine();
                String elements[] = line.split(",");
                Location location = new Location(0, elements[3], elements[4]);
                Event e = new Event(0,
                        elements[0],
                        Integer.parseInt(elements[1]),
                        Integer.parseInt(elements[2]),
                        location);
                events.add(e);
            }
        } catch (Exception e) {
        }
        return events;
    }

    public List<Location> loadLocations() {
        List<Location> locations = new ArrayList<Location>();

        try {
            locationsInput.nextLine();
            while (locationsInput.hasNext()) {
                String line = locationsInput.nextLine();
                String elements[] = line.split(",");
                Location l = new Location(0,
                        elements[0],
                        elements[1]);
                locations.add(l);
            }
        } catch (Exception e) {
        }
        return locations;
    }

    public List<User> loadUsers() {
        List<User> users = new ArrayList<User>();
        try {
            usersInput.nextLine();
            while (usersInput.hasNext()) {
                String line = usersInput.nextLine();
                String elements[] = line.split(",");
                User u = new User(
                        0,
                        elements[0],
                        elements[1],
                        elements[2],
                        elements[3]
                );
                users.add(u);
            }
        } catch (Exception e) {
        }

        return users;

    }
}
