package service;

import model.Event;
import repositories.IEventRepository;

import java.util.List;

public class IterateEventsService {

    public List<Event> iterateEvents(){
        IEventRepository eventRepository = IEventRepository.build(IEventRepository.Type.FILE);
        return eventRepository.getEvents();
    }

    public static IterateEventsService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final class SingletonHolder {
        private static final IterateEventsService INSTANCE = new IterateEventsService();
    }
}


