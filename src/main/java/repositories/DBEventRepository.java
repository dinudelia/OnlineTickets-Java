package repositories;

import managers.DBConnectionManager;
import managers.DBOperations;
import model.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DBEventRepository implements IEventRepository  {

    @Override
    public void addEvent(Event event) {
        DBOperations.addEvent(event);
    }

    @Override
    public void deleteEvent(Event event) {
        if (event!=null)
            DBOperations.deleteEvent(event);
    }

    @Override
    public List<Event> getEvents() {
        return DBOperations.allEvents();
    }
}
