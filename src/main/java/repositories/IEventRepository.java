package repositories;

import model.Client;
import model.Event;

import java.util.List;

public interface IEventRepository {

    void addEvent(Event event);
    void deleteEvent(Event event);
    List<Event> getEvents();

    static IEventRepository build(Type type) {
        switch (type) {
            case DB: return new DBEventRepository();
            case FILE: return new FileEventRepository();
            case ARRAY:return new ArrayEventRepository();
        }
        throw new RuntimeException("No such type");
    }

    enum Type {
        DB, FILE, ARRAY
    }
}
