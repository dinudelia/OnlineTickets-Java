package files;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.List;



public class SaveFiles {
    Formatter output;
    File usersFile = new File("USERS");
    File clientsFile = new File("CLIENTS");
    File eventsFile = new File("EVENTS");
    File locationsFile = new File("LOCATIONS");

    Formatter usersOutput;
    Formatter clientsOutput;
    Formatter eventsOutput;
    Formatter locationsOutput;

    public SaveFiles(){
        try {
            FileWriter fw1 = new FileWriter(usersFile,true);
            usersOutput = new Formatter(fw1);

           FileWriter fw2 = new FileWriter(clientsFile,true);
            clientsOutput = new Formatter(fw2);

            FileWriter fw3 = new FileWriter(eventsFile,true);
            eventsOutput = new Formatter(fw3);

            FileWriter fw4 = new FileWriter(locationsFile,true);
            locationsOutput = new Formatter(fw4);

        } catch(FileNotFoundException e)
        {
        } catch (IOException e) {
        }
    }
    public void saveClient(Client c){
        clientsOutput.format("\n%s,", c.getUsername());
        clientsOutput.format("%s,", c.getPassword());
        clientsOutput.format("%s,",c.getFirstName());
        clientsOutput.format("%s,",c.getLastName());
        clientsOutput.format("%d",c.getSeniority());
        clientsOutput.flush();
    }

    public void rewriteEvents(List<Event> eventsList){
        try {
            FileWriter fw3 = new FileWriter(eventsFile, false);
            eventsOutput = new Formatter(fw3);

        }catch (IOException ioe)
        {
        };
        for (Event e:eventsList) {
            eventsOutput.format("\n%s,", e.getNameEvent());
            eventsOutput.format("%d,", e.getNrTickets());
            eventsOutput.format("%d,", e.getPrice());
            eventsOutput.format("%s,", e.getLocation().getNameLocation());
            eventsOutput.format("%s", e.getLocation().getCity());
        }
        eventsOutput.flush();

    }
    public void saveEvent(Event e){
        eventsOutput.format("\n%s,",e.getNameEvent());
        eventsOutput.format("%d,",e.getNrTickets());
        eventsOutput.format("%d,",e.getPrice());
        eventsOutput.format("%s,",e.getLocation().getNameLocation());
        eventsOutput.format("%s",e.getLocation().getCity());
        eventsOutput.flush();
    }
    public void saveLocation(Location l) {
        locationsOutput.format("\n%s,", l.getNameLocation());
        locationsOutput.format("%s", l.getCity());
        locationsOutput.flush();
    }

    public void saveUser(User u) {
        usersOutput.format("\n%s,", u.getUsername());
        usersOutput.format("%s,", u.getPassword());
        usersOutput.format("%s,",u.getUsername());
        usersOutput.format("%s",u.getLastName());
        usersOutput.flush();
    }
}
