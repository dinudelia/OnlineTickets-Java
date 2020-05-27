package repositories;

import model.Client;
import model.Event;

import java.util.ArrayList;
import java.util.List;

public class ArrayEventRepository implements IEventRepository {

    List<Event> eventsList = new ArrayList<Event>();

    @Override
    public void addEvent(Event event) {
        eventsList.add(event);
    }

    @Override
    public void deleteEvent(Event event) {
        if (event!=null)
            eventsList.remove(event);
    }

    @Override
    public List<Event> getEvents() {
        return eventsList;
    }
}
